package cicada.thrift.server;


import cicada.core.BeanFactory;
import cicada.thrift.zookeeper.ConnectionFailProcessMode;
import cicada.thrift.zookeeper.ServicePublisher;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
@Scope("prototype")
public class RpcServerImpl implements RpcServer, DisposableBean {
    private static final int ClientTimeoutDefault = 300000;
    private static final int MinThreadsDefault = 10;
    private static final int MaxThreadsDefault = 10000;
    private ServerConfiguration _serverConfiguration;
    private ServicePublisher _servicePublisher;
    private static final Logger log = LoggerFactory.getLogger(RpcServerImpl.class);
    private boolean _published;
    private TServer _server;

    public RpcServerImpl(ServerConfiguration serverConfiguration, ServicePublisher servicePublisher) {
        this._serverConfiguration = serverConfiguration;
        this._servicePublisher = servicePublisher;
        String respositoryServer = this._serverConfiguration.getPublishRespositoryServer();
        ConnectionFailProcessMode connectionFailProcessMode = this._serverConfiguration.getConnectionFailProcessMode();
        String publishName = this._serverConfiguration.getPublishName();
        String publishServer = this._serverConfiguration.getPublishServer();
        int port = this._serverConfiguration.getPort();
        this._servicePublisher.Init(respositoryServer, connectionFailProcessMode, publishName, publishServer + ":" + port);
    }

    public <T> void run(Class<T> classzz) {
        if (classzz.isInterface() && classzz != null) {
            String processorName = classzz.getName().replace("Iface", "") + "Processor";
            RpcServerImpl.ThriftSevice<T> runPrivateRunnable = new RpcServerImpl.ThriftSevice(processorName, classzz);
            Thread privateRunable = new Thread(runPrivateRunnable);
            privateRunable.start();
            RpcServerImpl.PublishRunable publishRunable = new RpcServerImpl.PublishRunable();
            Thread threadPublish = new Thread(publishRunable);
            threadPublish.start();
        } else {
            log.info("{}不是接口", classzz.getName());
        }
    }

    public void close() {
        if (this._published) {
            this._servicePublisher.cancel();
        }

        if (this._server != null) {
            this._server.stop();
        }

    }

    public void destroy() throws Exception {
        try {
            if (this._servicePublisher != null) {
                this._servicePublisher.destroy();
                this._servicePublisher = null;
            }

            if (this._server != null) {
                this._server.stop();
                this._server = null;
            }
        } catch (Throwable var2) {
            log.error(var2.getMessage(), var2);
        }

    }

    public class ThriftSevice<T> implements Runnable {
        private String _processorName;
        private Class<T> _classzz;

        public ThriftSevice(String this$0, Class<T> processorName) {
            this._processorName = this$0;
            this._classzz = processorName;
        }

        public void run() {
            try {
                Class<?> classProcess = Class.forName(this._processorName);
                T iface = BeanFactory.getBeanByType(this._classzz);
                Constructor<?> constructor = classProcess.getConstructor(this._classzz);
                TProcessor tprocessor = (TProcessor)constructor.newInstance(iface);
                TServerSocket serverTransport = new TServerSocket(RpcServerImpl.this._serverConfiguration.getPort(), 300000);
                TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
                tArgs.processor(tprocessor);
                tArgs.protocolFactory(new TCompactProtocol.Factory());
                tArgs.maxWorkerThreads = 10000;
                tArgs.minWorkerThreads = 10;
                tArgs.inputTransportFactory(new TTransportFactory());
                tArgs.outputTransportFactory(new TTransportFactory());
                RpcServerImpl.this._server = new TThreadPoolServer(tArgs);
                RpcServerImpl.this._server.serve();
            } catch (ClassNotFoundException var7) {
                RpcServerImpl.log.info("没有发现将要向外公开的服务接口,请确保您用的是Thrift生成的服务接口");
            } catch (TTransportException var8) {
                var8.printStackTrace();
            } catch (IllegalAccessException | InstantiationException var9) {
                var9.printStackTrace();
            } catch (NoSuchMethodException var10) {
                var10.printStackTrace();
            } catch (SecurityException var11) {
                var11.printStackTrace();
            } catch (IllegalArgumentException var12) {
                var12.printStackTrace();
            } catch (InvocationTargetException var13) {
                var13.printStackTrace();
            }

        }
    }

    public class PublishRunable implements Runnable {
        public PublishRunable() {
        }

        public void run() {
            if (RpcServerImpl.this._serverConfiguration.getPublishRespositoryServer() != null && !RpcServerImpl.this._serverConfiguration.getPublishRespositoryServer().isEmpty()) {
                RpcServerImpl.this._published = true;

                try {
                    Thread.sleep(5000L);
                    RpcServerImpl.this._servicePublisher.publish();
                } catch (InterruptedException var3) {
                    String mString = String.format("rpc 发布服务出错:%s", var3.getMessage());
                    RpcServerImpl.log.error(mString, var3);
                }

            }
        }
    }
}

package com.dingxiang.server;

import com.dingxiang.BeanFactory;
import com.dingxiang.zookeeper.ServicePublisher;
import org.apache.log4j.Logger;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RpcServerImpl implements RpcServer, DisposableBean {

    private static final Logger log = Logger.getLogger(RpcServerImpl.class);
    private static final int ClientTimeoutDefault = 300000;
    private static final int MinThreadsDefault = 10;
    private static final int MaxThreadsDefault = 10000;

    private ServerConfiguration _serverConfiguration;
    private ServicePublisher _servicePublisher;
    private boolean _published;
    private TServer _server;

    public RpcServerImpl(ServerConfiguration _serverConfiguration, ServicePublisher servicePublisher) {
        this._serverConfiguration = _serverConfiguration;
        this._servicePublisher = servicePublisher;

        _servicePublisher.Init(_serverConfiguration.getPublishRespositoryServer(),
                _serverConfiguration.getConnectionFailProcessMode(), _serverConfiguration.getPublishName(),
                _serverConfiguration.getPublishServer() + ":" + _serverConfiguration.getPort());
    }

    @Override
    public <T> void run(Class<T> classzz) {
        if (classzz == null || !classzz.isInterface()) {
            log.info(String.format("%s不是接口", classzz.getName()));
            return;
        }
        String processorName = classzz.getName().replace("Iface", "") + "Processor";

        ThriftSevice<T> runPrivateRunnable = new ThriftSevice<T>(processorName, classzz);
        Thread privateRunable = new Thread(runPrivateRunnable);
        privateRunable.start();

        PublishRunable publishRunable = new PublishRunable();
        Thread threadPublish = new Thread(publishRunable);
        threadPublish.start();
    }

    public class PublishRunable implements Runnable {
        @Override
        public void run() {
            if (_serverConfiguration.getPublishRespositoryServer() == null || _serverConfiguration.getPublishRespositoryServer().isEmpty()) {
                return;
            }
            _published = true;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            _servicePublisher.publish();
        }
    }

    public class ThriftSevice<T> implements Runnable {
        private String _processorName;
        private Class<T> _classzz;

        public ThriftSevice(String processorName, Class<T> classzz) {
            _processorName = processorName;
            _classzz = classzz;
        }

        @Override
        public void run() {
            try {
                Class<?> classProcess = Class.forName(_processorName);
                T iface = BeanFactory.getBeanByType(_classzz);
                Constructor<?> constructor = classProcess.getConstructor(_classzz);

                TProcessor tprocessor = (TProcessor) constructor.newInstance(iface);
                TServerSocket serverTransport = new TServerSocket(_serverConfiguration.getPort(), ClientTimeoutDefault);

                TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
                tArgs.processor(tprocessor);
                tArgs.protocolFactory(new TCompactProtocol.Factory());
                tArgs.maxWorkerThreads = MaxThreadsDefault;
                tArgs.minWorkerThreads = MinThreadsDefault;
                tArgs.inputTransportFactory(new TTransportFactory());
                tArgs.outputTransportFactory(new TTransportFactory());
                _server = new TThreadPoolServer(tArgs);
                _server.serve();
            } catch (ClassNotFoundException e) {
                log.info("没有发现将要向外公开的服务接口,请确保您用的是Thrift生成的服务接口");
            } catch (TTransportException e) {
                e.printStackTrace();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        if (this._published) {
            this._servicePublisher.cancel();
        }

        if (this._server != null) {
            this._server.stop();
        }
    }

    @Override
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
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
    }
}

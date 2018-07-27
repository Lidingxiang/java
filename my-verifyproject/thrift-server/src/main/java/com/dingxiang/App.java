package com.dingxiang;

import com.dingxiang.driver.HelloWorldService;
import com.dingxiang.helloimpl.HelloWorldServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        System.out.println("ServerStart!");
        App server = new App();
        server.startServer();

    }

    /**
     * 启动Thrift服务器
     */
    private void startServer() {
        try {
            //定义传输的socket，设置服务端口为6789
            TServerSocket serverTransport = new TServerSocket(6789);

            //设置协议工厂为TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true, true);

            //关联处理器与Hello服务的实现
//            HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());
            TProcessor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());

            //定义服务端的参数值
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);
            args.processor(processor);
            args.protocolFactory(proFactory);

            TServer server = new TThreadPoolServer(args);

            //服务端开启服务
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}

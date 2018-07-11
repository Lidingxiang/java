package com.dingxiang;

import com.dingxiang.helloImpl.HelloWorldServiceImpl;
import com.dingxiang.hellodriver.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * 启动服务
 *
 * @author dingxm
 */
public class StartServer {

    public static void main(String[] args) {
        System.out.println("ServerStart!");
        StartServer server = new StartServer();
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
            TBinaryProtocol.Factory proFactory = new Factory(true, true);

            //关联处理器与Hello服务的实现

//            HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());
            TProcessor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());

            //定义服务端的参数值
            Args args = new Args(serverTransport);
            args.processor(processor);
            args.protocolFactory(proFactory);

            TServer server = new TThreadPoolServer(args);

            //服务端开启服务
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动Thrift服务器
     */
    /*private void startServer2() {
        try {
            //定义传输的socket，设置服务端口为6789
            TServerSocket serverTransport = new TServerSocket(6789);

            //设置协议工厂为TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new Factory(true,true);

            //关联处理器与Hello服务的实现
//            HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());
            TProcessor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());



            //定义服务端的参数值
            Args args = new Args(serverTransport);
            args.processor(processor);
            args.protocolFactory(proFactory);

            TServer server = new TThreadPoolServer(args);

            //服务端开启服务
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }*/
}
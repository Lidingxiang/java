package com.dingxiang;

import com.dingxiang.hellodriver.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class App2 {
    public static void main(String[] args){
        // 设置调用的服务地址为本地，端口为6789
        try {
            TTransport transport = new TSocket("localhost", 6789);
            transport.open();
            // 数据传输协议有：二进制协议、压缩协议、JSON格式协议
            // 这里使用二进制协议
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            // 调用服务器端的服务方法
            System.out.println(client.sayHello("萝卜白菜，各有所爱!"));
            // 关闭
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}

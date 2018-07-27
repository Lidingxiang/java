package com.dingxiang.client;

import com.dingxiang.client.servicefinders.ServiceFinder;

public class EndpointInfo {

    private Class<?> contractType;//com.dingxiang.hellodriver.HelloWorldService$Iface
    private Class<?> clientType;//com.dingxiang.hellodriver.HelloWorldService$Client
    private String server;//直连时机器地址
    private int port;//直连时端口
    private String serviceFinderType;//链接方式(字符):direct;ServiceCentre
    private ServiceFinder serverceFinder;//链接方式(ServiceFinder):ServiceFindersImplDirect;ServiceFindersImplCentre
    private String ServiceCentreRespositoryServer;//zookeeper服务器地址
    private String ServiceCentreName;//zookeeper发现路径 /rpc/ldx/demo/v1.0

    public Class<?> getContractType() {
        return contractType;
    }

    public void setContractType(Class<?> contractType) {
        this.contractType = contractType;
    }

    public Class<?> getClientType() {
        return clientType;
    }

    public void setClientType(Class<?> clientType) {
        this.clientType = clientType;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceFinderType() {
        return serviceFinderType;
    }

    public void setServiceFinderType(String serviceFinderType) {
        this.serviceFinderType = serviceFinderType;
    }

    public ServiceFinder getServerceFinder() {
        return serverceFinder;
    }

    public void setServerceFinder(ServiceFinder serverceFinder) {
        this.serverceFinder = serverceFinder;
    }

    public String getServiceCentreRespositoryServer() {
        return ServiceCentreRespositoryServer;
    }

    public void setServiceCentreRespositoryServer(String serviceCentreRespositoryServer) {
        ServiceCentreRespositoryServer = serviceCentreRespositoryServer;
    }

    public String getServiceCentreName() {
        return ServiceCentreName;
    }

    public void setServiceCentreName(String serviceCentreName) {
        ServiceCentreName = serviceCentreName;
    }

    @Override
    public String toString() {
        return "EndpointInfo{" +
                "contractType=" + contractType +
                ", clientType=" + clientType +
                ", server='" + server + '\'' +
                ", port=" + port +
                ", serviceFinderType='" + serviceFinderType + '\'' +
                ", serverceFinder=" + serverceFinder +
                ", ServiceCentreRespositoryServer='" + ServiceCentreRespositoryServer + '\'' +
                ", ServiceCentreName='" + ServiceCentreName + '\'' +
                '}';
    }
}

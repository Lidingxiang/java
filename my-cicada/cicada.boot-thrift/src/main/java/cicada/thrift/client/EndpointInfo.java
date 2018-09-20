package cicada.thrift.client;


import cicada.thrift.client.servicefinders.ServiceFinder;

public class EndpointInfo {
    private Class<?> contractType;
    private Class<?> clientType;
    private String server;
    private int port;
    private String serviceFinderType;
    private ServiceFinder serverceFinder;
    private String ServiceCentreRespositoryServer;
    private String ServiceCentreName;

    public EndpointInfo() {
    }

    public ServiceFinder getServerceFinder() {
        return this.serverceFinder;
    }

    public void setServerceFinder(ServiceFinder serverceFinder) {
        this.serverceFinder = serverceFinder;
    }

    public String getServiceCentreRespositoryServer() {
        return this.ServiceCentreRespositoryServer;
    }

    public void setServiceCentreRespositoryServer(String serviceCentreRespositoryServer) {
        this.ServiceCentreRespositoryServer = serviceCentreRespositoryServer;
    }

    public String getServiceCentreName() {
        return this.ServiceCentreName;
    }

    public void setServiceCentreName(String serviceCentreName) {
        this.ServiceCentreName = serviceCentreName;
    }

    public Class<?> getContractType() {
        return this.contractType;
    }

    public void setContractType(Class<?> contractType) {
        this.contractType = contractType;
    }

    public Class<?> getClientType() {
        return this.clientType;
    }

    public void setClientType(Class<?> clientType) {
        this.clientType = clientType;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceFinderType() {
        return this.serviceFinderType;
    }

    public void setServiceFinderType(String serviceFinderType) {
        this.serviceFinderType = serviceFinderType;
    }
}
package cicada.thrift.server;


import cicada.thrift.zookeeper.ConnectionFailProcessMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ServerConfiguration {
    private final String PORT_CONFIGN_AME = "Cicada.Rpc.Server.Port";
    private final String PUBLISH_RESPOSITORY_SERVERCONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.RespositoryServer";
    private final String PUBLISHNAME_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.Name";
    private final String PUBLISH_SERVER_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.Server";
    private final String CONNECTION_FAIL_PROCESSMODE_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.ConnectionFailProcessMode";
    private Environment _configurationDataRespository;
    private int port;
    private String publishRespositoryServer;
    private String publishName;
    private String publishServer;
    private ConnectionFailProcessMode ConnectionFailProcessMode;

    public int getPort() {
        return this.port;
    }

    public String getPublishRespositoryServer() {
        return this.publishRespositoryServer;
    }

    public String getPublishName() {
        return this.publishName;
    }

    public String getPublishServer() {
        return this.publishServer;
    }

    public ConnectionFailProcessMode getConnectionFailProcessMode() {
        return this.ConnectionFailProcessMode;
    }

    public ServerConfiguration(Environment env) throws Exception {
        this._configurationDataRespository = env;
        this.setPort();
        this.setPublishRespositoryServer();
        if (this.publishRespositoryServer != null && !this.publishRespositoryServer.isEmpty()) {
            this.setPublishName();
            this.setPublishServer();
        }

        this.setConnectionFailProcessMode();
    }

    private void setPort() throws Exception {
        String strPort = this._configurationDataRespository.getProperty("Cicada.Rpc.Server.Port");
        if (strPort != null && !strPort.isEmpty()) {
            this.port = Integer.parseInt(strPort.trim());
        }

        if (this.port == 0) {
            throw new Exception(String.format("请为RPC服务器配置端口，请修改配置项%s", "Cicada.Rpc.Server.Port"));
        }
    }

    private void setPublishRespositoryServer() {
        String text = this._configurationDataRespository.getProperty("Cicada.Rpc.Server.ServiceCentre.RespositoryServer");
        this.publishRespositoryServer = text != null && !text.isEmpty() ? text.trim() : "";
    }

    private void setPublishName() throws Exception {
        String text = this._configurationDataRespository.getProperty("Cicada.Rpc.Server.ServiceCentre.Name");
        if (text != null && !text.isEmpty()) {
            this.publishName = text.trim();
        } else {
            throw new Exception(String.format("请为RPC服务器配置发布名称，请修改配置项%s", "Cicada.Rpc.Server.ServiceCentre.Name"));
        }
    }

    private void setPublishServer() throws Exception {
        String text = this._configurationDataRespository.getProperty("Cicada.Rpc.Server.ServiceCentre.Server");
        if (text != null && !text.isEmpty()) {
            this.publishServer = text.trim();
        } else {
            throw new Exception(String.format("请为RPC服务器配置发布服务器地址，请修改配置项%s", "Cicada.Rpc.Server.ServiceCentre.Server"));
        }
    }

    private void setConnectionFailProcessMode() throws Exception {
        String value = this._configurationDataRespository.getProperty("Cicada.Rpc.Server.ServiceCentre.ConnectionFailProcessMode");
        ConnectionFailProcessMode connectionFailProcessMode = cicada.thrift.zookeeper.ConnectionFailProcessMode.Retry;
        if (value != null && !value.isEmpty()) {
            if (!value.equals(cicada.thrift.zookeeper.ConnectionFailProcessMode.Retry.toString()) && !value.equals(cicada.thrift.zookeeper.ConnectionFailProcessMode.Throw.toString())) {
                throw new Exception(String.format("您为连接注册中心出现错误时配置的处理方式无效，必须为Throw或者Retry，请修改配置项%s", "Cicada.Rpc.Server.ServiceCentre.ConnectionFailProcessMode"));
            }

            if (value.equals(cicada.thrift.zookeeper.ConnectionFailProcessMode.Retry.toString())) {
                this.ConnectionFailProcessMode = cicada.thrift.zookeeper.ConnectionFailProcessMode.Retry;
            } else {
                this.ConnectionFailProcessMode = cicada.thrift.zookeeper.ConnectionFailProcessMode.Throw;
            }
        } else {
            this.ConnectionFailProcessMode = connectionFailProcessMode;
        }

    }
}

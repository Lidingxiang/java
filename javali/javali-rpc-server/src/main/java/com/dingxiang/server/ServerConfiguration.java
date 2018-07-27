package com.dingxiang.server;

import com.dingxiang.zookeeper.ConnectionFailProcessMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ServerConfiguration {
    //port_confign_ame
    private final String PORT_CONFIGN_AME = "Cicada.Rpc.Server.Port";
    //publish_respository_serverconfigname
    private final String PUBLISH_RESPOSITORY_SERVERCONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.RespositoryServer";
    //publishname_configname
    private final String PUBLISHNAME_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.Name";
    //publish_server_configname
    private final String PUBLISH_SERVER_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.Server";
    //connection_fail_processmode_configname
    private final String CONNECTION_FAIL_PROCESSMODE_CONFIGNAME = "Cicada.Rpc.Server.ServiceCentre.ConnectionFailProcessMode";

    public int getPort() {
        return port;
    }

    public String getPublishRespositoryServer() {
        return publishRespositoryServer;
    }

    public String getPublishName() {
        return publishName;
    }

    public String getPublishServer() {
        return publishServer;
    }

    public com.dingxiang.zookeeper.ConnectionFailProcessMode getConnectionFailProcessMode() {
        return ConnectionFailProcessMode;
    }

    private int port;
    private String publishRespositoryServer;
    private String publishName;
    private String publishServer;
    private ConnectionFailProcessMode ConnectionFailProcessMode;

    private Environment _configurationDataRespository;

    public ServerConfiguration(Environment _configurationDataRespository) throws Exception {
        this._configurationDataRespository = _configurationDataRespository;
        this.setPort();
        this.setPublishRespositoryServer();

        if (this.publishRespositoryServer != null && !this.publishRespositoryServer.isEmpty()) {
            this.setPublishName();
            this.setPublishServer();
        }
        this.setConnectionFailProcessMode();
    }

    private void setPort() throws Exception {
        String strPort = this._configurationDataRespository.getProperty(PORT_CONFIGN_AME);
        if (strPort != null && !strPort.isEmpty()) {
            this.port = Integer.parseInt(strPort.trim());
        }
        if (this.port == 0) {
            throw new Exception(String.format("请为RPC服务器配置端口，请修改配置项%s", PORT_CONFIGN_AME));
        }
    }

    private void setPublishRespositoryServer() {
        String text = this._configurationDataRespository.getProperty(PUBLISH_RESPOSITORY_SERVERCONFIGNAME);
        this.publishRespositoryServer = ((text == null || text.isEmpty()) ? "" : text.trim());
    }

    private void setPublishName() throws Exception {
        String text = this._configurationDataRespository.getProperty(PUBLISHNAME_CONFIGNAME);
        if (text == null || text.isEmpty()) {
            throw new Exception(String.format("请为RPC服务器配置发布名称，请修改配置项%s", PUBLISHNAME_CONFIGNAME));
        }
        this.publishName = text.trim();
    }

    private void setPublishServer() throws Exception {
        String text = this._configurationDataRespository.getProperty(PUBLISH_SERVER_CONFIGNAME);
        if (text == null || text.isEmpty()) {
            throw new Exception(String.format("请为RPC服务器配置发布服务器地址，请修改配置项%s", PUBLISH_SERVER_CONFIGNAME));
        }
        this.publishServer = text.trim();
    }

    private void setConnectionFailProcessMode() throws Exception {
        String value = this._configurationDataRespository.getProperty(CONNECTION_FAIL_PROCESSMODE_CONFIGNAME);
        ConnectionFailProcessMode connectionFailProcessMode = ConnectionFailProcessMode.Retry;
        if (value == null || value.isEmpty()) {
            this.ConnectionFailProcessMode = connectionFailProcessMode;
        } else {
            if (!value.equals(ConnectionFailProcessMode.Retry.toString()) && !value.equals(ConnectionFailProcessMode.Throw.toString())) {
                throw new Exception(String.format("您为连接注册中心出现错误时配置的处理方式无效，必须为Throw或者Retry，请修改配置项%s", CONNECTION_FAIL_PROCESSMODE_CONFIGNAME));
            } else {
                if (value.equals(ConnectionFailProcessMode.Retry.toString())) {
                    this.ConnectionFailProcessMode = ConnectionFailProcessMode.Retry;
                } else {
                    this.ConnectionFailProcessMode = ConnectionFailProcessMode.Throw;
                }
            }
        }
    }

}

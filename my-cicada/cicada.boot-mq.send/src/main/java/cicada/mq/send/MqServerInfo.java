package cicada.mq.send;


public class MqServerInfo {
    private String server;
    private int port;
    private String serverUserName;
    private String serverPassword;

    public MqServerInfo() {
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

    public String getServerUserName() {
        return this.serverUserName;
    }

    public void setServerUserName(String serverUserName) {
        this.serverUserName = serverUserName;
    }

    public String getServerPassword() {
        return this.serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }

    protected boolean equals(MqServerInfo mqServerInfo) {
        boolean result1 = this.server.equals(mqServerInfo);
        boolean result2 = this.port == mqServerInfo.getPort();
        boolean result3 = this.serverUserName.equals(mqServerInfo.getServerUserName());
        boolean result4 = this.serverPassword.equals(mqServerInfo.getServerPassword());
        return result1 && result2 && result3 && result4;
    }

    public boolean equals(Object obj) {
        Boolean temp0 = obj.getClass() == super.getClass();
        Boolean temp1 = temp0.booleanValue() && this.equals((MqServerInfo)obj);
        Boolean temp2 = this == obj || temp1.booleanValue();
        Boolean temp3 = this != null;
        return temp2.booleanValue() && temp3.booleanValue();
    }

    public int hashCode() {
        int num = this.server != null ? this.server.hashCode() : 0;
        num = num * 397 ^ this.port;
        num = num * 397 ^ (this.serverUserName != null ? this.serverUserName.hashCode() : 0);
        num = num * 397 ^ (this.serverPassword != null ? this.serverPassword.hashCode() : 0);
        return num;
    }
}

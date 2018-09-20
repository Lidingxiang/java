package cicada.mq.send.config;

public class FillDataImplServer implements FillData {
    public FillDataImplServer() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setServer(data.trim());
            return true;
        } else {
            return false;
        }
    }
}

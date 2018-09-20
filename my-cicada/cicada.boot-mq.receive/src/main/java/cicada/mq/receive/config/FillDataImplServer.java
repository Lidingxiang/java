package cicada.mq.receive.config;

public class FillDataImplServer implements FillData {
    public FillDataImplServer() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            info.setServer(data.trim());
            return true;
        } else {
            return false;
        }
    }
}


package cicada.mq.receive.config;

public class FillDataImplServerUserName implements FillData {
    public FillDataImplServerUserName() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            info.setServerUserName(data.trim());
            return true;
        } else {
            return false;
        }
    }
}

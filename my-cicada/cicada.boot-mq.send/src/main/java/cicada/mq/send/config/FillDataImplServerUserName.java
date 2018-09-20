package cicada.mq.send.config;

public class FillDataImplServerUserName implements FillData {
    public FillDataImplServerUserName() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setServerUserName(data.trim());
            return true;
        } else {
            return true;
        }
    }
}

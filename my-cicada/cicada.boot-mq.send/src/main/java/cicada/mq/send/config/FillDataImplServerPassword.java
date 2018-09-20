package cicada.mq.send.config;

public class FillDataImplServerPassword implements FillData {
    public FillDataImplServerPassword() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setServerPassword(data.trim());
            return true;
        } else {
            return true;
        }
    }
}
package cicada.mq.receive.config;


public class FillDataImplServerPassword implements FillData {
    public FillDataImplServerPassword() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            info.setServerPassword(data.trim());
            return true;
        } else {
            return false;
        }
    }
}

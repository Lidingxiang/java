package cicada.mq.receive.config;


public class FillDataImplChannelName implements FillData {
    public FillDataImplChannelName() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            info.setChannelName(data.trim().toLowerCase());
            return true;
        } else {
            return false;
        }
    }
}

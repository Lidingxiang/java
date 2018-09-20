package cicada.mq.send.config;

public class FillDataImplChannelName implements FillData {
    public FillDataImplChannelName() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setChannelName(data.trim().toLowerCase());
            return true;
        } else {
            return false;
        }
    }
}

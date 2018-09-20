package cicada.mq.send.config;


public class FillDataImplPort implements FillData {
    public FillDataImplPort() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        if (data != null && !data.isEmpty()) {
            try {
                int port = Integer.parseInt(data);
                info.setPort(port);
                return true;
            } catch (Exception var6) {
                throw new IllegalArgumentException(String.format("请配置正确的端口号,修改%s配置项", configName));
            }
        } else {
            return true;
        }
    }
}

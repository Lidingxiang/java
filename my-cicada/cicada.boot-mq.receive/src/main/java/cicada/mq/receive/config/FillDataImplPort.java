package cicada.mq.receive.config;


public class FillDataImplPort implements FillData {
    public FillDataImplPort() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            int port;
            try {
                port = Integer.parseInt(data);
            } catch (Exception var7) {
                throw new Exception(String.format("请配置正确的端口号,修改%s配置项", configName));
            }

            info.setPort(port);
            return true;
        } else {
            return true;
        }
    }
}

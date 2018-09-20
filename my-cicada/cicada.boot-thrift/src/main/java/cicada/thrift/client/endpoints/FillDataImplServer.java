package cicada.thrift.client.endpoints;


import cicada.thrift.client.EndpointInfo;

public class FillDataImplServer implements FillData {
    public FillDataImplServer() {
    }

    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            String[] array = data.split(":");
            if (array != null && array.length == 2) {
                info.setServer(array[0].trim());

                try {
                    int port = Integer.parseInt(array[1]);
                    info.setPort(port);
                    return true;
                } catch (Exception var7) {
                    throw new Exception(String.format("配置的值%s不是有效的端口号，请检查%s配置项", data, configName));
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}

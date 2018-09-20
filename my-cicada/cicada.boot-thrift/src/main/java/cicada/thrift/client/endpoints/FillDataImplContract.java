package cicada.thrift.client.endpoints;


import cicada.thrift.client.EndpointInfo;

public class FillDataImplContract implements FillData {
    public FillDataImplContract() {
    }

    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            try {
                Class<?> contractType = Class.forName(data);
                if (contractType != null && contractType.isInterface()) {
                    info.setContractType(contractType);
                    data = data.replace("Iface", "Client");
                    Class<?> client = Class.forName(data);
                    if (client != null) {
                        info.setClientType(Class.forName(data));
                        return true;
                    } else {
                        throw new Exception(String.format("您配置接口类型%s不是Thrift生成的接口类型，请修改%s节点", data, configName));
                    }
                } else {
                    return false;
                }
            } catch (ClassNotFoundException var7) {
                String mString = String.format("thrift 接口配置不正确:%s,请修改节点:%s,错误信息:%s", data, configName, var7);
                throw new Exception(mString);
            }
        } else {
            return false;
        }
    }
}

package cicada.thrift.client.endpoints;


import cicada.thrift.client.EndpointInfo;

public class FillDataImplServerCentreRespository implements FillData {
    public FillDataImplServerCentreRespository() {
    }

    public boolean fill(String configName, String key, String data, EndpointInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setServiceCentreRespositoryServer(data.trim());
            return true;
        } else {
            return true;
        }
    }
}

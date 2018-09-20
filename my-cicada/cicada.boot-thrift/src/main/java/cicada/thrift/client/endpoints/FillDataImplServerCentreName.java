package cicada.thrift.client.endpoints;


import cicada.thrift.client.EndpointInfo;

public class FillDataImplServerCentreName implements FillData {
    public FillDataImplServerCentreName() {
    }

    public boolean fill(String configName, String key, String data, EndpointInfo info) {
        if (data != null && !data.isEmpty()) {
            info.setServiceCentreName(data);
            return true;
        } else {
            return true;
        }
    }
}

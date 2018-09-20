package cicada.thrift.client.endpoints;

import cicada.core.BeanFactory;
import cicada.thrift.client.EndpointInfo;
import cicada.thrift.client.servicefinders.ServiceFinder;

public class FillDataImplServiceFinderType implements FillData {
    public FillDataImplServiceFinderType() {
    }

    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {
        String text = data != null && !data.isEmpty() ? data.trim() : "direct";
        text = text.toLowerCase();
        ServiceFinder serviceFinder = (ServiceFinder) BeanFactory.getBeanByName(text);
        if (serviceFinder == null) {
            throw new Exception(String.format("您配置Rpc服务发现类型%s是无效的，请修改%s节点", data, configName));
        } else {
            info.setServiceFinderType(text);
            info.setServerceFinder(serviceFinder);
            return true;
        }
    }
}
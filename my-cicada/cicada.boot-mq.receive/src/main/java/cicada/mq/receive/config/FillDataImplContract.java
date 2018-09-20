package cicada.mq.receive.config;


import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;


public class FillDataImplContract implements FillData {
//    private static final Logger log = LoggerFactory.getLogger(FillDataImplContract.class);

    public FillDataImplContract() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        if (data != null && !data.isEmpty()) {
            info.setContractType(Class.forName(data));
            if (info.getContractType() == null) {
                return false;
            } else if (!info.getContractType().isInterface() && !Modifier.isAbstract(info.getContractType().getModifiers())) {
                Class<?> temp = this.getMessageType(info.getContractType());
                info.setMessageType(temp);
                if (info.getMessageType() == null) {
                    throw new Exception(String.format("您配置的契约类型%s必须实现了Receiver接口，请修改%s节点", data, configName));
                } else {
                    return true;
                }
            } else {
                throw new Exception(String.format("您配置的契约类型%s必须是类并且不能是抽象的,请修改%s节点", data, configName));
            }
        } else {
            return false;
        }
    }

    private Class<?> getMessageType(Class<?> contractType) {
        try {
            ParameterizedType parameterizedType = (ParameterizedType)contractType.getGenericInterfaces()[0];
            Class<?> result = (Class)parameterizedType.getActualTypeArguments()[0];
            return result;
        } catch (Exception var4) {
            return null;
        }
    }
}
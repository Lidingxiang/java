package cicada.authorization;


import cicada.authorization.config.GetUserIdRet;
import cicada.authorization.config.UserSessionService.Iface;
import cicada.core.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAuthClient {
    static final Logger log = LoggerFactory.getLogger(UserAuthClient.class);
    static final byte[] lock = new byte[1];

    public UserAuthClient() {
    }

    public static GetUserIdRet getUserId(String sessionId) {
        Iface iface = (Iface)BeanFactory.getBeanByType(Iface.class);

        try {
            if (iface != null) {
                byte[] var2 = lock;
                synchronized(lock) {
                    GetUserIdRet result = iface.GetUserId(sessionId);
                    return result;
                }
            }
        } catch (Exception var6) {
            log.error("cicada.authorization 版块获取thrift 服务错误:{},详细信息:{}", var6.getMessage(), var6.getStackTrace());
        }

        log.error("cicada.authorization 版块获取thrift 服务错误,返回空值");
        return null;
    }
}

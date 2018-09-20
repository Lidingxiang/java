package cicada.thrift.client;


import cicada.thrift.client.servicefinders.ServiceFinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ThriftClientInterceptor implements InvocationHandler {
    private EndpointInfo _endpointInfo;
    private RpcClient _targetObject;
    private ServiceFinder serviceFinder;

    public ThriftClientInterceptor(EndpointInfo endpointInfo, RpcClient targetObject) throws Exception {
        this._endpointInfo = endpointInfo;
        this.serviceFinder = this._endpointInfo.getServerceFinder();
        this.serviceFinder.init(this._endpointInfo);
        this._targetObject = targetObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        this.excuteBefore();
        Object realClient = this._targetObject.GenerateProxyObject();
        Object result = method.invoke(realClient, args);
        this.excuteAfter();
        return result;
    }

    public void excuteBefore() throws Exception {
        this._targetObject.before();
    }

    public void excuteAfter() {
        this._targetObject.after();
    }
}
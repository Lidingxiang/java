package com.dingxiang.client;

import com.dingxiang.client.servicefinders.ServiceFinder;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ThriftClientInterceptor implements InvocationHandler {
    private static final Logger log = Logger.getLogger(ThriftClientInterceptor.class);

    private EndpointInfo _endpointInfo;
    private RpcClient _targetObject;
    private ServiceFinder serviceFinder;

    public ThriftClientInterceptor(EndpointInfo endpointInfo, RpcClient targetObject) throws Exception {
        _endpointInfo = endpointInfo;
        serviceFinder = this._endpointInfo.getServerceFinder();
        serviceFinder.init(_endpointInfo);
        _targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        excuteBefore();
        Object realClient = _targetObject.GenerateProxyObject();
        Object result = method.invoke(realClient, args);
        excuteAfter();
        return result;
    }

    public void excuteBefore() throws Exception {
        _targetObject.before();
    }

    public void excuteAfter() {
        _targetObject.after();
    }
}

package cn.edu.bjfu.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author chaos
 * @date 2022-10-09 14:15
 */
public class ProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }
}

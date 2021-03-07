package demo;

import java.lang.reflect.Proxy;

/**
 * @Author Xiaoma
 * @Date 2021/3/7 0007 16:07
 * @Email 1468835254@qq.com
 */
public class HelloHandlerProxy {

    public static void main(String[] args) {
        HelloInterface hello = new Hello();
        ProxyHandler handler = new ProxyHandler(hello);
        HelloInterface instance = (HelloInterface)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        instance.sayHello();
    }
}

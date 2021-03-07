package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Xiaoma
 * @Date 2021/3/7 0007 16:06
 * @Email 1468835254@qq.com
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object, args);
        return null;
    }
}

package demo;

/**
 * @Author Xiaoma
 * @Date 2021/3/7 0007 16:04
 * @Email 1468835254@qq.com
 */
public class HelloProxy implements HelloInterface{

    private HelloInterface helloInterface;

    @Override
    public void sayHello() {
        helloInterface.sayHello();
    }
}

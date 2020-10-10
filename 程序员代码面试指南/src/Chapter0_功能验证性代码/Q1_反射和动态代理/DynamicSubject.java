package Chapter0_功能验证性代码.Q1_反射和动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/06/2020 22:53
 **/

public class DynamicSubject implements InvocationHandler {
    Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling method ");
        method.invoke(sub,args);
        System.out.println("after calling method");
        return null;
    }


    public static void main(String[] args) {
        //实例化被代理对象
        RealSubject sub = new RealSubject();
        //用多态特性，实例化实现InvocationHandler的类,并转化成InvocationHandler类型
        InvocationHandler ds = new DynamicSubject(sub);
        //得到被代理类的类对象，方便获取类信息
        Class cls = sub.getClass();
        Request rs = (Request) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),ds);
        rs.request(1024);


        FakeSubject fs = new FakeSubject();
        InvocationHandler ifs = new DynamicSubject(fs);
        Class fss = fs.getClass();
        Request proxyFs = (Request) Proxy.newProxyInstance(fss.getClassLoader(),fss.getInterfaces(),ifs);
        proxyFs.request(2048);
    }
}

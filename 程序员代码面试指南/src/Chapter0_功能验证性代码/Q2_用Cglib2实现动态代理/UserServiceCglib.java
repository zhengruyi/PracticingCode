package Chapter0_功能验证性代码.Q2_用Cglib2实现动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/06/2020 23:19
 **/

public class UserServiceCglib implements MethodInterceptor {
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //指定代理类的父类
        enhancer.setSuperclass(this.target.getClass());
        //设定回调类
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public static void main(String[] args) {
        //创建被代理类
        UserServiceCglib cglib = new UserServiceCglib();
        //生成代理类
        UserService bookFacedImpl = (UserService) cglib.getInstance(new UserService());
        //调用代理类的方法
        bookFacedImpl.addUser();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始。。。");
        //调用父类的方法,也就是调用真实对象的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束。。。");
        return result;
    }
}

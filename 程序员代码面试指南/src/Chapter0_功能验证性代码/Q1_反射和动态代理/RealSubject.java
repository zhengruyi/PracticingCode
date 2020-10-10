package Chapter0_功能验证性代码.Q1_反射和动态代理;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/06/2020 22:52
 **/

public class RealSubject implements Request{
    @Override
    public void request(int id) {
        System.out.println("method is invoked with id : "+id);
    }
}

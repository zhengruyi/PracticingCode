package Chapter0_功能验证性代码.Q1_反射和动态代理;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/06/2020 23:08
 **/

public class FakeSubject implements Request{
    @Override
    public void request(int  info){
        System.out.println("this is a fake class, invoked with : "+info);
    }
}

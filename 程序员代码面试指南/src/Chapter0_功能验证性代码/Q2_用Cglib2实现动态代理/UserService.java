package Chapter0_功能验证性代码.Q2_用Cglib2实现动态代理;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/06/2020 23:17
 **/

public class UserService {
    public void addUser(){
        System.out.println("增加一个用户");
    }
    public void editUser(){
        System.out.println("编辑一个用户");
    }
}

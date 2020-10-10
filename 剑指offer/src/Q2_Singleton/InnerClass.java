package Q2_Singleton;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 20:43
 **/

public class InnerClass {

    private InnerClass(){
    }
    //通过内部类的加载方式可以做到延迟加载，相比静态构造有优势
    public static InnerClass getInstance(){
        return SingletonHolder.ic;
    }

    private static class SingletonHolder{
        private static final InnerClass ic = new InnerClass();
    }
}

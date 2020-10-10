package Q2_Singleton;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 20:34
 **/

public class DoubleCheck {
    //  为了保证一个线程的创建能立即被其他线程看到，需要加上volatile
    /*
       由于指令重排序的影响，或出现下面的情况:
       memory =allocate();    //1：分配对象的内存空间 

       ctorInstance(memory);  //2：初始化对象 

       instance =memory;     //3：设置instance指向刚分配的内存地址
       复制代码但是这些指令顺序并非一成不变，有可能会经过 JVM 和 CPU 的优化，指令重排成下面的顺序：
       memory =allocate();    //1：分配对象的内存空间 

       instance =memory;     //3：设置instance指向刚分配的内存地址 

       ctorInstance(memory);  //2：初始化对象

       会造成返回的对象是未初始化完的，为了禁止重排序要加volatile
       但是他无法解决反射带来的问题.
     */
    private volatile static DoubleCheck dc = null;

    private DoubleCheck() {

    }

    public static DoubleCheck getInstance() {
        if (dc == null) {
            synchronized (DoubleCheck.class) {
                if (dc == null) {
                    dc = new DoubleCheck();
                }
            }
        }
        return dc;
    }
}

class Test_DoubleCheck {
    public static void main(String[] args) {
        DoubleCheck dc1 = DoubleCheck.getInstance();
        DoubleCheck dc2 = DoubleCheck.getInstance();
        System.out.println(dc1 == dc2);
    }
}

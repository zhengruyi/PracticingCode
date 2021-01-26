package Q3_单例模式.Q2懒汉式_线程安全;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 00:14
 **/

/**
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。synchronized本质上是重量级锁，所以同步开销很大
 * 但是jdk.18之后经过优化，性能开销小了很多
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class Solution {
    private static Solution singleton;
    private Solution(){}
    public  static  synchronized Solution getInstance(){
        if(singleton ==  null){
            singleton = new Solution();
        }
        return singleton;
    }
}

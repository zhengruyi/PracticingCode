package Q3_单例模式.Q4双重校验锁;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 16:07
 **/

public class Solution {
    /**
     * JDK 版本：JDK1.5 起 从1,6后对synchronized进行优化，运行速度超过了lock等同步锁
     *
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：较复杂
     *
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * getInstance() 的性能对应用程序很关键。
     *
     * 但是双重校验可能会有序列化破坏单例的情况
     */

    //这里volatile保证一旦有线程初始化后其余线程可以立即看见
    private  static volatile Solution singleton;
    private Solution(){}
    public static Solution getInstance(){
        //检查实例有没有被初始化
        if(singleton == null){
            synchronized (Solution.class){
                //锁定后再次检查，防止在中间已经有其他线程实例化
                if(singleton == null){
                    singleton = new Solution();
                }
            }
        }
        return singleton;
    }
}

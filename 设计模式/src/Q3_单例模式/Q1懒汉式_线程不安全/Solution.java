package Q3_单例模式.Q1懒汉式_线程不安全;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 00:10
 **/

/**
 * 是否 Lazy 初始化：是 即用到时才会实例化
 *
 * 是否多线程安全：否 多线程很容易创造出多个不同实例
 *
 * 实现难度：易
 */
public class Solution {
    private Solution(){}
    private static Solution singleton;
    private static Solution getInstance(){
        if(singleton == null){
            singleton = new Solution();
        }
        return singleton;
    }
}

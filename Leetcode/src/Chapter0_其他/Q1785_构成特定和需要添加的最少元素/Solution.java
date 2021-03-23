package Chapter0_其他.Q1785_构成特定和需要添加的最少元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/03/2021 23:24
 **/

public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        double sum = 0.0;
        //统计数组的元素和
        for(int num : nums){
            sum += num;
        }
        //比较两者之间的差值,这里由于考虑的是两者之间的绝对距离
        //所以无论两个元素的同号还是异号,都可以计算绝对的距离
        sum = Math.abs(sum  - goal);
        //统计最少的次数,注意这里用double来进行统计，不然会出现数据溢出
        return (int)Math.ceil(sum / (double) limit);
    }
}

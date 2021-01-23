package Q56_数组中数字出现的次数II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:22
 **/

public class Solution {
    /**
     * 这里的表达式是按照twoOne这样的状态画出有限状态机来进行推导的
     * 这里表达式的相似性
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for(int num : nums){
            one =  one ^ num & ~two;
            two =  two ^ num & ~one;
        }
        return one;
    }
}

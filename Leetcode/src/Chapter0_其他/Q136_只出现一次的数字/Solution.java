package Chapter0_其他.Q136_只出现一次的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:30
 **/

public class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        //相同的两个数异或和是0，所以对数组中的所有的数字都进行异或运算
        //剩下的结果就是只出现一次的数字
        for(int i : nums){
            x = x ^ i;
        }
        return x;
    }
}

package Chapter0_其他.Q1470_重新排列数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/03/2021 22:43
 **/

public class Solution {
    /**
     * 这里的终点是数字大小小于1000,所以只用低10位存储，那么高位都是空的
     * 所以可以用高位储存移动后的数字，做到一个数字的低位是原来的数字，而高位是排序后的数字
     * 最后将低位全部移除，那么剩下的就是排序后的数字
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int len = n << 1;
        for(int i = 0; i < len; i++){
            int dist =  i < n ? i * 2 : (i - n ) * 2 + 1;
            nums[dist] = nums[dist] | ((nums[i] & 0x3ff) << 10);
        }
        for(int i = 0; i < len; i++){
            nums[i] >>= 10;
        }
        return nums;
    }
}

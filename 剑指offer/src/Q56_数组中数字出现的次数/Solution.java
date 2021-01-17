package Q56_数组中数字出现的次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:42
 **/

public class Solution {
    /**
     * 基本思路就是第一轮求出两个数字的异或和，然后根据异或和中的哪一位是1来将元数组进行分组
     * 然后在根据这一位的不同将原数组分组，然后求出一个只出现一次的数组，求出所有其他元素
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        int diff = 1;
        while((xor & diff) == 0){
            diff <<= 1;
        }
        int t1 = 0;
        for(int num : nums){
            if((num & diff) > 0 ){
                t1 ^= num;
            }
        }
        return new int[]{xor ^ t1, t1};
    }
}

package Chapter0_其他.Q260_只出现一次的数字II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/01/2021 21:46
 **/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        //统计所有数字的异或，由于只有两个数字不同，所以最后的结果就是两个数字的异或
        for(int num : nums){
            xor ^= num;
        }
        int tmp = xor;
        int threshold = 1;
        //找出最终结果最右边的一位数字
        while((tmp & 0x1) == 0){
            tmp >>= 1;
            threshold <<= 1;
        }
        //两个数字的异或和有一位是1,表示这两个数字在这一位不同，那么可以依据这一位是否为1将数组分成两部分，然后求异或和
        //就可以得到两个不同的数字
        int t1 = 0;
        for(int num : nums){
            if((num & threshold) > 0){
                t1 ^= num;
            }
        }
        return new int[]{t1, xor ^ t1};

    }
}

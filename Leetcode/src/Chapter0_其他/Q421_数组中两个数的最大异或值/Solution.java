package Chapter0_其他.Q421_数组中两个数的最大异或值;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 15:43
 **/

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int currXor = 0, maxXor = 0, max = 0;
        //保存数字的前缀和
        Set <Integer> prefixes = new HashSet <>();
        //获取数组中的最大值
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        //获取最长字符串的二进制字符长度，因为后面要逐位进行计算
        int L = (Integer.toBinaryString(max)).length();
        //从最高位开始计算
        for(int i = L-1; i >= 0; i--){
            //当前求得的最大值左移一位给新的位置留下空间
            maxXor <<= 1;
            //假设的最大值，如果存在则把这个值付给maxXor,不存在则直接跳过当前位置保存为0
            currXor = maxXor | 1;
            //清空集合
            prefixes.clear();
            //将所有数字的前缀放入到集合中
            for(int num : nums){
                prefixes.add(num >> i);
            }
            //由于异或运算交换律的存在,即 a ^ b = c ，那么 c ^ b  = a 也存在
            for(int p : prefixes){
                //表示集合中是否有两个数字的异或结果值等于currXor
                if(prefixes.contains(currXor ^ p)){
                    maxXor = currXor;
                }
            }
        }
        return maxXor;
    }
}

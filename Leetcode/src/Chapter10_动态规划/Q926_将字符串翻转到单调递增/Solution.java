package Chapter10_动态规划.Q926_将字符串翻转到单调递增;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/02/2021 23:46
 **/

public class Solution {
    public int minFlipsMonoIncr(String s) {
        //zero表示从开始到现在都是0需要的变化次数
        int zero = 0;
        //便是从开始到现在是1的变化次数
        int one = 0;
        for(int i = 0; i < s.length(); i++){
            int oldZero = zero;
            //由于要求序列是递增的,所以0的前序只能是0
            zero = zero + (s.charAt(i) == '0' ? 0 : 1);
            //1的前序可能是0或者是1
            one = Math.min(oldZero,one) + (s.charAt(i) == '1' ? 0 : 1);
        }
        //返回最终的结果的最小值
        return Math.min(zero,one);
    }
}

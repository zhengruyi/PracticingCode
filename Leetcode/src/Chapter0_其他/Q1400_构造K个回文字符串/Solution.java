package Chapter0_其他.Q1400_构造K个回文字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 22:51
 **/

public class Solution {
    /**
     * 这里主要讨论划分成回文字符串的最少和最多个数，做多就是字符串长度，
     * 因为每个单独的字符就是一个回文字符串，最少的数目是出现次数为奇数的字符个数
     * 可以通过拆解长的回文字符串来获取更多但更短的回文字符串
     * @param s
     * @param k
     * @return
     */
    public boolean canConstruct(String s, int k) {
        int[] times = new int[26];
        //统计字符出现频率
        for(int i = 0; i < s.length(); i++){
            times[s.charAt(i) - 'a']++;
        }
        int left = 0;
        //最少要划分成的回文字符串数目
        for(int i = 0; i < times.length; i++){
            if(times[i] % 2 == 1){
                ++left;
            }
        }
        left = Math.max(left,1);
        return k >= left && k <= s.length();
    }
}

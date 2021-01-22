package Chapter5_滑动窗口算法.Q1234_替换子串得到平衡字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:09
 **/

public class Solution {
    /**
     * 这里的滑动窗口算法很特殊是计算总量后然后减去窗口中的字符串中的出现频率
     * @param s
     * @return
     */
    public int balancedString(String s) {
        int[] freq = new int[26];
        int len = s.length();
        //统计字符串中QWER四个字符的出现次数
        for(int i = 0; i < len; i++){
            freq[s.charAt(i) - 'A']++;
        }
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        for(right = 0; right < len; right++){
            //减去窗口中的字符出现频率
            freq[s.charAt(right) - 'A']--;
            //当窗口内的字符串符合要求时，收缩左边界，从而找到满足要求的最短字符串
            while(left < len && freq['Q' - 'A'] <= len /4 && freq['W' - 'A'] <= len /4 && freq['E' - 'A'] <= len /4
                    && freq['R' - 'A'] <= len /4){
                res = Math.min(res, right - left + 1);
                //收缩左边界时，这里以外面的字符串频率为准,所以要给对应的字符频率加1
                freq[s.charAt(left++) - 'A']++;
            }
        }
        return res;
    }
}

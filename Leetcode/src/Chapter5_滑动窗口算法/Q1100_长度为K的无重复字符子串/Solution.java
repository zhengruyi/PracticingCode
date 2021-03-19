package Chapter5_滑动窗口算法.Q1100_长度为K的无重复字符子串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/03/2021 23:13
 **/

public class Solution {
    public int numKLenSubstrNoRepeats(String s, int K) {
        if(s.length() < K){
            return 0;
        }
        int res = 0;
        //按长度截取字符串,送入函数进行统计,最后统计符合要求的子字符串的个数
        for(int i = 0; i + K <= s.length(); i++){
            res += check(s.substring(i,i+K));
        }
        return res;
    }

    /**
     * 因为字符串里面只有小写字符,所以用数组统计频率,有重复字符就返回0
     * 没有重复字符,那么返回1
     * @param s
     * @return
     */
    public int check(String s){
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(count[index] > 0){
                return 0;
            }
            count[index]++;
        }
        return 1;
    }
}

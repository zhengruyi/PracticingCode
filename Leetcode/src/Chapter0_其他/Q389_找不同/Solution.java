package Chapter0_其他.Q389_找不同;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/03/2021 21:54
 **/

public class Solution {
    /**
     * 统计字符频率来找出差别字符
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] times = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            times[index] ++;
        }
        for(int i = 0; i < t.length(); i++){
            int index = t.charAt(i) - 'a';
            if(times[index] == 0){
                return (char)('a' + index);
            }
            times[index]--;
        }
        return ' ';
    }
}

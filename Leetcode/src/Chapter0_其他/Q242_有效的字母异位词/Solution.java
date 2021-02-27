package Chapter0_其他.Q242_有效的字母异位词;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/02/2021 22:47
 **/

public class Solution {
    /**
     * 统计字符串的每个字符出现频率是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] times = new int[128];
        for(int i = 0; i < s.length(); i++){
            int index = (int)(s.charAt(i));
            times[index]++;
        }
        for(int i = 0; i < t.length(); i++){
            int index = (int)(t.charAt(i));
            if(times[index] > 0){
                times[index] --;
            }else{
                return false;
            }
        }
        return true;
    }
}

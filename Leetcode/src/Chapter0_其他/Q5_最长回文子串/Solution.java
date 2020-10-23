package Chapter0_其他.Q5_最长回文子串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/10/2020 21:24
 **/

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null){
            return "";
        }
        char[] chars = s.toCharArray();
        String res = "";
        for(int i = 0; i < chars.length; i++){
            String l1 = longestPalindrome(s,chars,i,i);
            String l2 = longestPalindrome(s,chars,i, i+1);
            res = res.length() > l1.length() ? res : l1;
            res = res.length() > l2.length() ? res : l2;
        }
        return res;
    }

    /**
     * 通过i和j来统一以i为中心的子串和以i,i+1为中心的计算方式,时间复杂度为O(N^2)
     * @param s
     * @param chars
     * @param i
     * @param j
     * @return
     */
    public String longestPalindrome(String s, char[]chars, int i, int j){
        while(i>= 0 && j < chars.length && chars[i] == chars[j]){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}

package Chapter0_其他.Q459_重复的子字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:01
 **/

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //将两个字符串合并到一起，就会将s的所偶遇可能的旋转都包含在内
        String str = s+s;
        //如果旋转过后仍然包含原始字符串，那么就说明原始字符串是由多个相同字符串组合而来
        return str.substring(1,str.length()-1).contains(s);
    }
}

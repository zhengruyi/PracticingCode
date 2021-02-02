package Chapter0_其他.Q524_通过删除字母匹配到字典里最长单词;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/02/2021 23:30
 **/

public class Solution {
    public String findLongestWord(String s, List <String> d) {
        String res = "";
        for(String str : d){
            //检查str是否是s的子序列，如果是那么就可以将s的某些字符删去来达成str
            if(isSubsequence(str,s)){
                //如果当前字符串长度更长或者字典序列更小那么就更新答案
                if(res.length() < str.length() || (res.length() == str.length() && str.compareTo(res) < 0)){
                    res = str;
                }
            }
        }
        return res;
    }

    /**
     * 检查字符串x是不是字符串s的子序列
     * @param x
     * @param s
     * @return
     */
    public boolean isSubsequence(String x, String s){
        int j = 0;
        int len = s.length();
        for(int i = 0; i < len && j < x.length(); i++){
            if(x.charAt(j) == s.charAt(i)){
                j++;
            }
        }
        return j == x.length();
    }
}

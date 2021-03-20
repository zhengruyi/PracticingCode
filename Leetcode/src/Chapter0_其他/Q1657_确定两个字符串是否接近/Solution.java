package Chapter0_其他.Q1657_确定两个字符串是否接近;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/03/2021 21:52
 **/

public class Solution {
    /**
     * 转换过程中两种操作一个是调换两个字符的位置,一个是将一类字符全部替换成另外一类
     * 所以总的来说,两个字符串接近的意思是首先字符串长度相同, 种类相同,其次字符串的不同字符的出现次数排序后也是相同的
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < word1.length(); i++){
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < count1.length; i++){
            if((count1[i] > 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] > 0)){
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for(int i = 0; i < count1.length; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}

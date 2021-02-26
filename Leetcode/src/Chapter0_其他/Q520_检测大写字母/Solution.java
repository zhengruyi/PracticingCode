package Chapter0_其他.Q520_检测大写字母;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/02/2021 23:51
 **/

public class Solution {
    /**
     * 计算大写字母的个数看是否符合条件
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int num  = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                num++;
            }
        }
        return num == 0 || num == word.length() || (num == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}

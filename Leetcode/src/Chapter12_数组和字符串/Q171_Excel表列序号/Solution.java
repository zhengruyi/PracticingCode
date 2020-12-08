package Chapter12_数组和字符串.Q171_Excel表列序号;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/12/2020 22:57
 **/

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            res = res * 26 + s.charAt(i) -'A' + 1;
        }
        return res;
    }
}

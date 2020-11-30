package Chapter12_数组和字符串.Q344_翻转字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:22
 **/

public class Solution {
    public void reverseString(char[] s) {
        int begin = 0;
        int end = s.length -1;
        //双指针用法
        while(begin < end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }
}

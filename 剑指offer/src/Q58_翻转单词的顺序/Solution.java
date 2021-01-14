package Q58_翻转单词的顺序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:35
 **/

public class Solution {
    /**
     * 除了先翻转所有单词再依次把每个单词翻转一下来看
     * 这里采用倒序切割字符串
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        int j = s.length() - 1;
        int i = j;
        while(i >= 0){
            //遇到空个停下
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            //切分字符串加入builder中
            builder.append(s.substring(i+1,j+1));
            builder.append(" ");
            //将连续的空格压缩到一个
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return builder.toString().trim();
    }
}

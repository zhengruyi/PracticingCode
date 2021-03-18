package Q58_左旋转字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/03/2021 23:35
 **/

public class Solution {
    /**
     * 简单的拼接逻辑
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder(s);
        builder.append(s);
        int len = s.length();
        return builder.toString().substring(n,n+len);
    }
}

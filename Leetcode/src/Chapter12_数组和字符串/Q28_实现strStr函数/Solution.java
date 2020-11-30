package Chapter12_数组和字符串.Q28_实现strStr函数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:14
 **/

public class Solution {
    //这里用KMP算法来实现快速查找
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = buildNext(needle);
        int tar = 0;
        int pos = 0;
        while(tar < haystack.length()){
            if(haystack.charAt(tar) == needle.charAt(pos)){
                tar++;
                pos++;
                //不相等时根据next[]数组计算退回的位置
            }else if(pos != 0){
                pos = next[pos-1];
            }else{
                tar++;
            }
            //如果模式串全部匹配完毕，那么返回匹配的起始索引
            if(pos == needle.length()){
                return tar - pos;
            }
        }
        return -1;
    }
    //构建next数组，构建方法就是自己和自己做匹配
    public int[] buildNext(String needle){
        int len = needle.length();
        int[] next = new int[len];
        int i = 1, now = 0;
        while(i < len){
            //如果i和now的字符相等，那么代表以i结尾的字符串的最长公共前后缀在now的基础上加一
            if(needle.charAt(i) == needle.charAt(now)){
                now++;
                next[i] = now;
                i++;
                //如果不相等，那么代表now就要退回next[now-1]
            }else if(now != 0){
                now = next[now-1];
            }else{
                next[i] = now;
                i++;
            }
        }
        return next;
    }
}

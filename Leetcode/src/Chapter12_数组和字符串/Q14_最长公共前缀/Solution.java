package Chapter12_数组和字符串.Q14_最长公共前缀;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 23:34
 **/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        char c = ' ';
        //纵向比较法
        for(int i = 0; i < strs.length; i= (i+1)%strs.length){
            if(i == 0){
                //在首字符串时更新要匹配的字符
                if(index < strs[i].length()){
                    c = strs[i].charAt(index);
                }else{
                    break;
                }

            }else{
                //如果有字符串不等于当前字符或者长度不够，则直接退出
                if(strs[i].length() <= index || strs[i].charAt(index) != c){
                    break;
                }
                //在末尾处将这个字符加入作为最长公共前缀的一部分
                if(i == strs.length -1){
                    builder.append(c);
                    index++;
                }
            }

        }
        return builder.toString();
    }
}

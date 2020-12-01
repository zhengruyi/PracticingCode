package Chapter12_数组和字符串.Q557_反转字符串中的单词III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:13
 **/

public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int start = -1;
        int i;
        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                builder.append(new StringBuilder(s.substring(start+1,i)).reverse().toString());
                start = i;
                builder.append(' ');
            }
        }
        builder.append(new StringBuilder(s.substring(start+1,i)).reverse().toString());
        return builder.toString();

    }
}

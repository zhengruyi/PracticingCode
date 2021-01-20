package Chapter0_其他.Q271_字符串的编码与解码;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/01/2021 21:54
 **/

public class Solution {
    /**
     * 把int数字转化成4个字符的长度,这是因为如果直接转化成字符串的话不知道表示长度
     * 的字符串会多长，从而无法切割字符串
     * @param x
     * @return
     */
    public String intToString(int x){
        char[] chars = new char[4];
        //将高位数字24-32位右移24位后放入0位置
        //然后批处理16-24,8-16,0-8
        for(int i = 3; i >= 0; i--){
            chars[3 - i] = (char)((x >>(i * 8)) & 0xff);
        }
        return new String(chars);
    }

    // Encodes a list of strings to a single string.
    public String encode(List <String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s : strs){
            //先放入字符串长度在放入字符串内容
            builder.append(intToString(s.length()));
            builder.append(s);
        }
        return builder.toString();
    }

    public int stringToInteger(String s){
        int len = 0;
        //每次右移8位在加上当前字符
        for(char c : s.toCharArray()){
            len = (len << 8) + (int) c;
        }
        return len;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        //开头固定四个字符表示长度，后面接变长的字符串
        while(index < s.length()){
            int len = stringToInteger(s.substring(index,index+4));
            index+=4;
            res.add(s.substring(index,index+len));
            index+= len;
        }
        return res;
    }
}

package Chapter0_其他.Q1451_重新排列句子中的单词;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/02/2021 23:01
 **/

public class Solution {
    public String arrangeWords(String text) {
        String[] s = text.toLowerCase().split("\\s+");
        //java自带的排序方法就是原地排序
        Arrays.sort(s,(a, b) -> a.length() - b.length());
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            if(i == 0){
                //将首字符串首字符转化成大写
                String t = s[i];
                char head = (char)(t.charAt(0) - 32);
                builder.append(head);
                builder.append(t.substring(1));
            }else{
                builder.append(s[i]);
            }
            //拼接结果字符串
            builder.append(" ");
        }
        //拼接结果，返回
        return builder.toString().trim();
    }
}

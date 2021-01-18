package Chapter0_其他.Q833_字符串中的查找与替换;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:43
 **/

public class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder builder = new StringBuilder();
        int[] match = new int[S.length()];
        Arrays.fill(match,-1);
        for(int i = 0; i < indexes.length; i++){
            //查找在原子父串中的对应位置的子字符串是否和source中的字符串相等
            //相等就将在match数组对应位置赋值，便是当前位置需要替换
            if(S.substring(indexes[i],indexes[i]+sources[i].length()).equals(sources[i])){
                match[indexes[i]] = i;
            }
        }
        int index = 0;
        while(index < S.length()){
            //表示当前位置需要进行替换
            if(match[index] >= 0){
                //加替换后的字符串压入，然后更新索引
                builder.append(targets[match[index]]);
                index += sources[match[index]].length();
            }else{
                //说明当前索引没变动将原来的字符压入
                builder.append(S.charAt(index++));
            }
        }
        return builder.toString();
    }
}

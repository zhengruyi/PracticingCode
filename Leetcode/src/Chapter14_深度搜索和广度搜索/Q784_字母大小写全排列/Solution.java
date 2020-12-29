package Chapter14_深度搜索和广度搜索.Q784_字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 20:49
 **/

public class Solution {
    List <String> res = new ArrayList <>();
    int offset = 'A' - 'a';
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        dfs(chars,builder,0);
        return res;
    }
    public void dfs(char[] chars, StringBuilder builder, int index){
        if(index == chars.length){
            res.add(builder.toString());
            return;
        }
        //数字就原样加入
        if(chars[index] <= '9' && chars[index] >= '0'){
            builder.append(chars[index]);
            dfs(chars,builder,index+1);
            builder.deleteCharAt(builder.length()-1);
        }else{
            //字符先原样加入然后在把它转化大小写加入就可以
            builder.append(chars[index]);
            dfs(chars,builder,index+1);
            builder.deleteCharAt(builder.length()-1);
            if(chars[index] >= 'a' && chars[index] <='z'){
                builder.append((char)(chars[index] + offset));
            }else{
                builder.append((char)(chars[index] - offset));
            }
            dfs(chars,builder,index+1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}

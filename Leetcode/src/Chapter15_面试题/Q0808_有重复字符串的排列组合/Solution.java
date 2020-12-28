package Chapter15_面试题.Q0808_有重复字符串的排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 22:58
 **/

public class Solution {
    boolean used[];
    List <String> res;
    public String[] permutation(String s) {
        int len = s.length();
        used = new boolean[len];
        res = new ArrayList <>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        dfs(chars,builder);
        return res.toArray(new String[res.size()]);
    }

    /**
     * 核心在于排除重复字符串的选项,对字符串排序后保证相同的字符靠在一起
     * 然后分析情况可以知道重复出现需要满足的情况
     * used[i] || (i-1 >= 0 && chars[i-1] == chars[i] && !used[i-1]
     * @param chars
     * @param builder
     */
    public void dfs(char[] chars,StringBuilder builder){
        //循环终止条件,所有字符都已经遍历过了
        if(builder.length() == chars.length){
            res.add(builder.toString());
            return;
        }
        for(int i = 0; i < chars.length; i++){
            if(used[i] || (i-1 >= 0 && chars[i-1] == chars[i] && !used[i-1])){
                continue;
            }
            used[i] = true;
            builder.append(chars[i]);
            dfs(chars,builder);
            builder.deleteCharAt(builder.length() -1);
            used[i] = false;
        }
    }
}

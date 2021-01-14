package Chapter14_深度搜索和广度搜索.Q131_分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:19
 **/

public class Solution {
    List<List <String>> res = new ArrayList <>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return res;
        }
        int len = s.length();
        //由于需要经常判断字符串是否为回文字符串，所以这里用动态规划
        dp = new boolean[len][len];
        //先遍历right,在遍历left因为dp[i][j]要用到dp[i+1][j-1]
        //
        for(int j = 0; j < len; j++){
            for(int i = 0; i < len; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        dfs(s,len,new ArrayList<>(),0);
        return res;
    }
    public void dfs(String s, int len, List<String> path, int start){
        if(start == len){
            res.add(new ArrayList<>(path));
        }
        for(int i = start; i < len; i++){
            //检查start..i这中间的字符串是不是会回文的，是就继续遍历，不是就直接剪枝
            if(!dp[start][i]){
                continue;
            }
            //回溯遍历下一层
            path.add(s.substring(start,i+1));
            dfs(s,len,path,i+1);
            path.remove(path.size() - 1);
        }
    }
}

package Chapter10_动态规划.Q139_单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 21:17
 **/

public class Solution {
    public boolean wordBreak(String s, List <String> wordDict) {
        //转化成集合的目的就是为了更快地查找单词是否存在
        Set <String> set = new HashSet <>(wordDict);
        int len = s.length();
        //dp表示从0..i的字符串能否被字典中的单词包含
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                //如果dp[j]为真，那表示前面的字符串可以被包含，如果从j..i的字符串
                //也可以被包含，那么从0..i的字符串都可以被字典的单词包含
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}

package Chapter0_其他.Q1177_构建回文串检测;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/01/2021 23:04
 **/

public class Solution {
    public List <Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        //用来统计从0..i的字符子串，每个字符的出现频率
        //times[i+1]是在times[i]的基础上进行统计，所以用到clone()方法
        int[][] times = new int[n+1][26];
        for(int i = 0; i < n; i++){
            times[i+1] = times[i].clone();
            times[i+1][s.charAt(i) - 'a']++;
        }
        //申明布尔数组
        List<Boolean> res = new ArrayList <>();
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            res.add(isPairWord(times,left,right,k));
        }
        return res;
    }
    public boolean isPairWord(int[][] times, int left, int right, int k){
        int oddCount = 0;
        //统计两者之间的字符子串的各个字符出现的频率
        //如果出现偶数次字符，则本身就可以构成回文串
        //如果是奇数个字符的出现次数等于2，那么就需要使用一次变换能力
        //如果K降到0以下，就返回false
        for(int i = 0; i < 26; i++){
            if((times[right+1][i] - times[left][i]) % 2 != 0){
                oddCount++;
            }
            if(oddCount == 2){
                k--;
                oddCount = 0;
            }
            if(k < 0){
                return false;
            }
        }
        return true;
    }
}

package Chapter0_其他.Q916_单词子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:01
 **/

public class Solution {
    public List <String> wordSubsets(String[] A, String[] B) {
        int[] freq = new int[26];
        for(String  s : B){
            int[] times = new int[26];
            //统计B中所有单词的各个字符需要出现的最大次数，
            //注意这里是最大字符，因为目标字符串的一个字符可以匹配多个B的子串
            for(int i = 0; i < s.length(); i++){
                int index = s.charAt(i) - 'a';
                times[index]++;
                freq[index] = Math.max(freq[index],times[index]);
            }
        }
        List<String> res = new ArrayList <>();
        for(int i = 0; i < A.length; i++){
            int[] tmp = new int[26];
            //统计一个字符串中的各个字符出现次数
            for(int j = 0; j < A[i].length(); j++){
                tmp[A[i].charAt(j) - 'a'] ++;
            }
            //如果一个字符串的各个字符的出现次数都大于B中的所有字符串的字符出现的最大次数
            //那么该字符串满足条件
            for(int k = 0; k < 26; k++){
                if(tmp[k] < freq[k]){
                    break;
                }
                if(k == 25){
                    res.add(A[i]);
                }
            }
        }
        return res;
    }
}

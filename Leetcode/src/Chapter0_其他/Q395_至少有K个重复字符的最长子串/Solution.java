package Chapter0_其他.Q395_至少有K个重复字符的最长子串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 22:47
 **/

public class Solution {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        //统计字符的出现频率
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        //记录哪些字符的出现频率不及格，那么这些字符就是分割点
        //然后切分成更小的字符串进行分治操作，不断切割找到最长的子串
        List <Integer> split = new ArrayList <>();
        for(int i = 0; i < s.length();i++){
            if(count[s.charAt(i) - 'a'] < k){
                split.add(i);
            }
        }
        //不存在分割点，那么返回整个字符串的长度
        if(split.isEmpty()){
            return s.length();
        }
        //嵌入最后一个末尾节点，保证最后一段字符串也能够被处理
        split.add(s.length());
        int pre = 0;
        int max = 0;
        for(int i : split){
            //如果这个子串的长度小于目前已知的最大子串长度，那么就没有计算的必要
            if(i - pre > max){
                max = Math.max(max,longestSubstring(s.substring(pre,i),k));
            }
            pre = i + 1;
        }
        return max;
    }
}

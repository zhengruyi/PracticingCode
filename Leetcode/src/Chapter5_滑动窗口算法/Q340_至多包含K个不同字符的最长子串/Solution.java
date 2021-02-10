package Chapter5_滑动窗口算法.Q340_至多包含K个不同字符的最长子串;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/02/2021 20:32
 **/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //是用哈希表来统计滑动的窗口中的字符的种类和出现次数
        HashMap <Character,Integer> map = new HashMap<>();
        //左右边界
        int left = 0;
        int right = 0;
        int max = -1;
        int len = s.length();
        while(right < len){
            //右边界往右移动一次
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0) + 1);
            //如果窗口中的字符种类数目大于k,那么就需要收缩左边界
            while(map.size() > k){
                char c = s.charAt(left);
                //移动左边界,将左边的字符的出现次数减去1
                map.put(c,map.get(c) - 1);
                //如果出现次数等于0，那么就移除哈希表中的这项
                if(map.get(c) == 0){
                    map.remove(c);
                }
                left++;
            }
            //更新窗口的最大宽度
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}

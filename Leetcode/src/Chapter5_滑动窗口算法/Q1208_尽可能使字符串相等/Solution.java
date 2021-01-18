package Chapter5_滑动窗口算法.Q1208_尽可能使字符串相等;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 22:16
 **/

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right;
        int sum = 0;
        int max = -1;
        //窗口的右边界
        for(right = 0; right < s.length(); right++){
            //统计相等所需要的消耗
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            //如果区间损耗大于最大值则需要收缩左边界
            while(sum > maxCost){
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            //更新一次最大值
            max = Math.max(max,right - left + 1);
        }
        //最后到达右边界在更新一次
        max = Math.max(max,right - left);
        return max;
    }
}

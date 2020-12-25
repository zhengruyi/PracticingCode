package Q54_最长不包含重复字符的子字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:04
 **/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] times = new int[128];
        int left = 0;
        int len = s.length();
        int max = 0;
        int i = 0;
        for(;i < len; i++){
            char c = s.charAt(i);
            //没有重复字符串
            if(times[c] == 0){
                times[c] ++;
            }else{
                //检查到区间里有重复字符，收缩左边界来剔除重复字符
                while(s.charAt(left) != c){
                    times[s.charAt(left)]--;
                    left++;
                }
                //剔除重复字符
                left++;
            }
            //这时有效区间是[left,i]，所以区间长度是i - left  + 1
            max = Math.max(max, i - left + 1);
        }
        //这是区间是[left,i)因为 i = nums.length + 1,所以区间长度是i - left
        max = Math.max(max, i - left);
        return max;
    }
}

package Chapter5_滑动窗口算法.Q3_无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 22:56
 **/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set <Character> set = new HashSet <Character>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int len = -1;
        while(right < chars.length){
            char c = chars[right];
            //无重复则向右移动
            if(!set.contains(c)){
                set.add(c);
                right++;
            }else{
                //更新最大长度
                len = Math.max(len, right - left);
                //移动左边界直到移除重读字符
                while(chars[left] != c){
                    set.remove(chars[left]);
                    left++;
                }
                set.remove(chars[left]);
                left++;
            }
        }
        //这里注意，要在结束后重新验证一次，防止出现由于没有重复字符而导致的长度为-1的情况
        len = Math.max(len, right - left);
        return len;
    }
}

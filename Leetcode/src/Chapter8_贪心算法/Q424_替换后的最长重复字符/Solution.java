package Chapter8_贪心算法.Q424_替换后的最长重复字符;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/01/2021 21:57
 **/

public class Solution {
    /**
     * 基本思路就是贪心算法下的滑动窗口，如果窗口内的出现频率最高的字符为max
     * 那么只要(right- left +1）- max < k，那么right就可以继续向右边扩展
     * 否则就需要移动左边界,由于窗口长度只会扩大而不会缩小，所以最后的最长重复字符长度
     * 就是right - left,这里不加1的原因是因为最后right = s.length(),已经超边界
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap <Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        for(right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            //更新字符出现的频率
            map.put(c,map.getOrDefault(c,0)+1);
            //更新出现频率最高的字符
            max = Math.max(max,map.get(c));
            //如果不满足条件，那么就移动左边字符
            if((right - left + 1) - max > k){
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
                left++;
            }
        }
        //最后的窗口长度就是答案
        return right - left;
    }
}

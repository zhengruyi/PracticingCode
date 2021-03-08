package Chapter15_面试题.Q0104_回文排列;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/03/2021 22:57
 **/

public class Solution {
    /**
     * 检查字符串中的字符出现频率，如果出现频率为奇数的字符的个数不大于1则可以重排列成回文字符
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap <Character, Integer> map = new HashMap <>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}

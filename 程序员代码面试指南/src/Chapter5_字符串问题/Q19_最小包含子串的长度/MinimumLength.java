package Chapter5_字符串问题.Q19_最小包含子串的长度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 22:26
 **/

public class MinimumLength {
    public int getMinLength(String s, String target) {
        if (s == null || s.length() == 0 || s.length() < target.length()) {
            return 0;
        }
        HashMap <Character, Integer> map = new HashMap <>();
        initMap(target, map);
        int left = 0;
        int right = 0;
        int match = target.length();
        int minLength = Integer.MAX_VALUE;
        char[] chas = s.toCharArray();
        for (right = 0; right < chas.length; right++) {
            if (map.containsKey(chas[right])) {
                int num = map.get(chas[right]);
                if (num > 0) {
                    match--;
                }
                map.put(chas[right], num - 1);
            } else {
                map.put(chas[right], -1);
            }
            if (match == 0) {
                while (map.get(chas[left]) < 0) {
                    map.put(chas[left], map.get(chas[right]) + 1);
                    left++;
                }
                minLength = Math.min(minLength, right - left + 1);
                map.put(chas[left], map.get(chas[left]) + 1);
                match++;
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public void initMap(String target, HashMap <Character, Integer> map) {
        char[] chas = target.toCharArray();
        for (int i = 0; i < chas.length; i++) {
            if (map.containsKey(chas[i])) {
                map.put(chas[i], map.get(chas[i]) + 1);
            } else {
                map.put(chas[i], 1);
            }
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(3, getMinLength("adabbca", "acb"));
        Assertions.assertEquals(3, getMinLength("abcde", "ac"));
        Assertions.assertEquals(0, getMinLength("12345", "344"));
    }
}

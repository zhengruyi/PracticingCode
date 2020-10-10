package Chapter4_递归和动态规划.Q16_数组中最长连续序列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/06/2020 22:07
 **/

public class MaxSubsequence {
    public int getSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 1;
        HashMap <Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    public int merge(HashMap <Integer, Integer> map,int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(more, len);
        return len;
    }

    @Test
    void test() {
        int[] nums = {1, 5, 3, 6, 232, 4, 5, 2};
        Assertions.assertEquals(6, getSubsequence(nums));
    }
}

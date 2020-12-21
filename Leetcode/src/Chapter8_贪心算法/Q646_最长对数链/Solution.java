package Chapter8_贪心算法.Q646_最长对数链;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:49
 **/

public class Solution {
    public int findLongestChain(int[][] pairs) {
        //按末尾进行升序排序
        Arrays.sort(pairs,(o1, o2) -> o1[1] - o2[1]);
        int res = 0;
        int curr = Integer.MIN_VALUE;
        //在后续的空间中,当前终点值越小，则可能获得的对数链越长
        for(int[] pair : pairs){
            if(curr < pair[0]){
                res++;
                curr = pair[1];
            }
        }
        return res;
    }
}

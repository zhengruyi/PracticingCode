package Chapter5_滑动窗口算法.Q1218_最长定差子序列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:31
 **/

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map <Integer,Integer> map = new HashMap <>();
        int[] dp = new int[arr.length];
        //把所有dp数组都设置成1，因为任意一个数字都是一个等差序列
        //dp[i]定义表示以arr[i]结尾的最长等差序列长度
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i = 0; i < arr.length; i++){
            //查看前一个元素是否存在，然后更新以arr[i]结尾的最长递增序列长度
            //这里用哈希表表示因为后面出现的元素的最长等差序列的长度不会比前面出现的
            //同等字符的序列长度低，所以可以正常更新
            if(map.containsKey(arr[i] - difference)){
                dp[i] = Math.max(dp[i],map.get(arr[i] - difference) + 1);
                ans = Math.max(dp[i],ans);
            }
            //更新元素出现的位置
            map.put(arr[i],dp[i]);
        }
        return ans;
    }
}

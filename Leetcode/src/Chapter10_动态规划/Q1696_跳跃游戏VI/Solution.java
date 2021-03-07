package Chapter10_动态规划.Q1696_跳跃游戏VI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/03/2021 22:50
 **/

public class Solution {
    /**
     * 动态规划 dp[i] = Math.max(dp[i-1]....dp[i-k])+nums[i]
     * @param nums
     * @param k
     * @return
     */
    public int maxResult(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        Deque <Integer> queue = new LinkedList();
        queue.offer(0);
        for(int i = 1; i < nums.length; i++){
            //这里的重点就是如果在动态的过程中找到dp[i-k]..dp[i-1]之间的最大值
            //解决办法就是双端队列,每次从队尾填入，蒋倩小于这个值的所有元素出队
            while(!queue.isEmpty() && dp[i-1] >= dp[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offer(i-1);
            //将队头国旗的元素踢出去
            while(i - queue.peekFirst() > k){
                queue.pollFirst();
            }
            //剩下的就是dp[i-k]..dp[i-1]之间的最大的元素
            dp[i] = dp[queue.peekFirst()] + nums[i];
        }
        return dp[len - 1];
    }
}

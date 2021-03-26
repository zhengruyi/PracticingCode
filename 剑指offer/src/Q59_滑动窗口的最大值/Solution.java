package Q59_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/03/2021 22:27
 **/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //空数组返回空
        if(nums.length == 0){
            return new int[]{};
        }
        Deque <Integer> queue = new LinkedList();
        //创建答案数组
        int[] res = new int[nums.length - k + 1];
        //将前k-1个元素的最大值的下标保存在队列里面
        for(int i = 0; i < k - 1; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
        }
        int index = 0;
        for(int i = k-1; i < nums.length; i++){
            //首先将0..k之间的最大值的下标保存在队列里
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            //将当前下标入队
            queue.offer(i);
            //如果度列中的最大值在区间内那么就作为答案,否则就直接弹出，往后搜索
            while(!queue.isEmpty() && queue.peekFirst() < i - k + 1){
                queue.pollFirst();
            }
            res[index++] = nums[queue.peekFirst()];
        }
        return res;
    }
}

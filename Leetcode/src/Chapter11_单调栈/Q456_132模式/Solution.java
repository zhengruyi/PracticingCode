package Chapter11_单调栈.Q456_132模式;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:58
 **/

public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        Stack <Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        //因为是子序列，所以求出前缀最小值数组
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        for(int i = nums.length - 1; i >= 0; i--){
            //当前值之前存在一个较小的值
            if(nums[i] > min[i]){
                //倒过来遍历的栈中存在某个值大于最小值
                while(!stack.isEmpty() && min[i] >= stack.peek()){
                    stack.pop();
                }
                //如果这个栈顶元素还大于nums[i]那么久构成了132模式，返回true
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}

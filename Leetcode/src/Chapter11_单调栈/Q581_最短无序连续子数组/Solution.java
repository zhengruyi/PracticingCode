package Chapter11_单调栈.Q581_最短无序连续子数组;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:19
 **/

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack <Integer> stack = new Stack<>();
        int len = nums.length;
        int l = len;
        //单调递增栈，往右搜索来判断左边界，即右边较小的数字应该在左边的第l位
        for(int i = 0; i < len; i++){
            //如果当前元素小于栈顶，那么就连续弹栈,直到找到较小元素该放的位置
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                l = Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        int r = 0;
        //连续单调递减栈，从右往左遍历，直到左边较大的元素可以找到他的位置
        //这个位置就是右边界
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                r = Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        //左右边界之间的区间就是最少需要排序的区间
        return r - l > 0 ? r - l + 1: 0;
    }
}

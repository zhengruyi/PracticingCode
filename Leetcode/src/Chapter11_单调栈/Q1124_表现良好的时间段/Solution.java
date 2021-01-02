package Chapter11_单调栈.Q1124_表现良好的时间段;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 18:42
 **/

public class Solution {
    public int longestWPI(int[] hours) {
        int[] score = new int[hours.length];
        //根据工作时间是否大于8，将时间转化成1,-1
        for(int i = 0; i < hours.length; i++){
            score[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] preSum = new int[hours.length+1];
        //求出前缀和
        for(int i =1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + score[i-1];
        }
        //单调递减栈，后来计算preSum[j]-preSum[i] > 0 且j > i的最大区间
        Stack <Integer> stack = new Stack<>();
        for(int i =0; i < preSum.length; i++){
            if(stack.isEmpty() || preSum[i] < preSum[stack.peek()]){
                stack.push(i);
            }
        }
        //计算区间长度，优化措施就是i > res,因为i < res时必然不存在可能的区间长度大于res
        int res = 0;
        int i = preSum.length -1;
        while(i > res){
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]){
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }
            i--;
        }
        return res;
    }
}

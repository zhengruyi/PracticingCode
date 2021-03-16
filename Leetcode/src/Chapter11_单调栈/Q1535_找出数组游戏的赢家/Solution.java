package Chapter11_单调栈.Q1535_找出数组游戏的赢家;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/03/2021 21:51
 **/

public class Solution {
    public int getWinner(int[] arr, int k) {
        if(k == 1){
            return Math.max(arr[0],arr[1]);
        }
        //单调递增栈,栈里面保存数组的下标
        Stack <Integer> stack = new Stack();
        stack.push(0);
        for(int i = 1; i < arr.length; i++){
            if(arr[stack.peek()] < arr[i]){
                stack.push(i);
            }
            //主要考虑一点栈里面的下标出去0位置其实都已经在前面的比赛中赢过一次了
            //所以后面都是用i - stack.peek() == k - 1，0除外
            if((stack.peek() == 0 && i - stack.peek() == k) || (stack.peek() != 0 && i - stack.peek() == k - 1)){
                return arr[stack.peek()];
            }
        }
        return arr[stack.peek()];
    }
}

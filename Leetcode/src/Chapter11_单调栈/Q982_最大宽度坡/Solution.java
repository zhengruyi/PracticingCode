package Chapter11_单调栈.Q982_最大宽度坡;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/03/2021 21:53
 **/

public class Solution {
    /**
     * 运用单调栈的第一步就是想明白是单调递增还是递减,然后设么情况下压栈和弹栈
     * @param A
     * @return
     */
    public int maxWidthRamp(int[] A) {
        Stack <Integer> stack = new Stack();
        //单调递减栈,因为要求左边的数字小于等于右边的数字
        for(int i = 0; i < A.length; i++){
            if(stack.isEmpty() || A[stack.peek()] > A[i]){
                stack.push(i);
            }
        }
        int res = 0;
        //要求最大的宽度坡，那么Stack.peek() == i 表示从0..i之间的数字都大于A[i]
        //那么在i..j之间哪怕有数字比A[j]更小,但是最大的宽度在j处就已经求出来了
        for(int j = A.length - 1; j > 0; j--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[j]){
                res = Math.max(j- stack.peek(),res);
                stack.pop();
            }
        }
        return res;
    }
}

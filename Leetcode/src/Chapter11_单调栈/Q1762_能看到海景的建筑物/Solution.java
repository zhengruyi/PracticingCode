package Chapter11_单调栈.Q1762_能看到海景的建筑物;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:14
 **/

public class Solution {
    /**
     * 简单的单调栈,从底部到顶部逐渐增大,栈里面保存的是数组下标
     * @param heights
     * @return
     */
    public int[] findBuildings(int[] heights) {
        Stack <Integer> stack = new Stack();
        for(int i = heights.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(heights[i] > heights[stack.peek()]){
                    stack.push(i);
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }
}

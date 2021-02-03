package Chapter11_单调栈.Q1299_将每个元素替换为右侧最大元素;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/02/2021 23:29
 **/

public class Solution {
    /**
     * 从右侧开始,遍历数组并把数字压入单调递增栈
     * 然后从左往右遍历,所有索引小于栈顶元素的值的右侧最大值
     * 就是栈顶索引位置的元素,如果为空就是-1
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        Stack <Integer> stack = new Stack();
        //从右往左进行单调递增栈的遍历
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty() || arr[stack.peek()] < arr[i]){
                stack.push(i);
            }
        }
        //从左往右进行元素填入
        for(int i = 0; i < arr.length; i++){
            if(i == stack.peek()){
                stack.pop();
                arr[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            }else{
                arr[i] = arr[stack.peek()];
            }
        }
        return arr;
    }
}

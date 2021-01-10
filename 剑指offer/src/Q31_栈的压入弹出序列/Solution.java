package Q31_栈的压入弹出序列;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:24
 **/

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i < popped.length; i++){
            //主要以弹出序列为目标搜索压入序列麻醉后判断栈是否为空
            if(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                continue;
            }
            while(index < pushed.length && pushed[index] != popped[i]){
                stack.push(pushed[index++]);
            }
            index++;
        }
        return stack.isEmpty();
    }
}

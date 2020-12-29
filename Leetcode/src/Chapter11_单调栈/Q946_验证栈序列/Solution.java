package Chapter11_单调栈.Q946_验证栈序列;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 20:55
 **/

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i = 0; i < popped.length; i++){
            //如果栈为空或者栈顶元素不是目标元素poped[i].那么搜索入栈序列
            //直到找到目标元素
            if(stack.isEmpty() || stack.peek() != popped[i]){
                while(j < pushed.length){
                    stack.push(pushed[j]);
                    j++;
                    if(stack.peek() == popped[i]){
                        break;
                    }
                }
            }
            //如果搜索完入栈序列还找不到目标元素就返回false
            if(stack.peek() != popped[i]){
                return false;
            }
            stack.pop();
        }
        //遍历完出栈序列，栈中应该为空
        return stack.isEmpty();
    }
}

package Chapter11_单调栈.Q856_括号的分数;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 22:54
 **/

public class Solution {
    public int scoreOfParentheses(String s) {
        Stack <Integer> stack = new Stack<>();
        //由于每次需要弹出两个元素，所以这里做初始化
        stack.push(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }else{
                //遇到右括号时统计本层的分数加到上一层去
                int curr = stack.pop();
                int prev = stack.pop();
                stack.push(prev + Math.max(2 * curr, 1));
            }
        }
        return stack.peek();
    }
}

package Chapter11_单调栈.Q150_逆波兰表达式求值;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:17
 **/

public class Solution {
    /**
     * 逆波兰表达式就是将操作符放在两个操作数之后，
     * 所以这里用栈来保存前面两个操作数，碰到操作符是取出计算就可以
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("*")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t1 * t2);
            }else if(s.equals("+")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t1 + t2);
            }else if(s.equals("/")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            }else if(s.equals("-")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 - t1);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}

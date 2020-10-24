package Chapter0_其他.Q20_有效的括号;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/10/2020 22:42
 **/

public class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length;i++){
            if(chars[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }else if(chars[i] == ']'){
                if(stack.isEmpty()||stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }else if(chars[i] == '}'){
                if(stack.isEmpty()||stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}

package Chapter11_单调栈.Q678_有效的括号字符串;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:50
 **/

public class Solution {
    public boolean checkValidString(String s) {
        //两个栈分别用来保存左括号或者星号
        Stack <Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left.push(i);
            }
            if(s.charAt(i) == '*'){
                star.push(i);
            }
            if(s.charAt(i) == ')'){
                //遇到右括时先尽量用左括号去匹配，还不行的话可以用星号来代替左括号
                if(!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        //当两个栈都不为空且星号栈的索引在左括号栈的右边就可将
        //星号转换成右括号来达成匹配
        while(!left.isEmpty() && !star.isEmpty()){
            if(star.peek() < left.peek()){
                return false;
            }else{
                left.pop();
                star.pop();
            }
        }
        //最后左括号还有元素则匹配失败，空则整个字符串都有效
        return left.isEmpty();
    }
}

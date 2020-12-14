package Chapter11_单调栈.Q1047_删除字符串中的所有相邻重复项;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/12/2020 22:36
 **/

public class Solution {
    public String removeDuplicates(String s) {
        //考虑到相邻删除的特性，所以这里采用栈最合适
        Stack <Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i =0; i < s.length();i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        //此时栈里面的元素就是删除相邻元素的部分
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        //栈的输出顺序与输入顺序相反,所以要特意反向一下
        return builder.reverse().toString();
    }
}

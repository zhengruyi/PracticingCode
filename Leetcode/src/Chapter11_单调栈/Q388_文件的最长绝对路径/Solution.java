package Chapter11_单调栈.Q388_文件的最长绝对路径;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 20:56
 **/

public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        int ans = 0;
        //用来存放上一层的路径长度
        Stack <Integer> stack = new Stack<>();
        //初始状态，表上上层路径长度为0
        stack.push(0);
        //按照\n切分成不同层的子串
        String[] strs = input.split("\n");
        for(String s : strs){
            //lastIndexOf返回的值加1表示总共有多少个制表符
            int level = s.lastIndexOf("\t") + 1;
            //level+1表示在第几层,如果当前层数小于栈顶，那么就需要弹出栈顶元素
            while(level + 1 < stack.size()){
                stack.pop();
            }
            //父路径长度包含/,加上当前子串长度减去制表符，再加上末尾的/
            int len = stack.peek() + (s.length() - level + 1);
            //如果当前是文件，那么更新最长的路径长度,末尾减去1是指减去末尾的/
            if(s.contains(".")){
                ans = Math.max(ans,len - 1);
            }
            //压入栈中
            stack.push(len);
        }
        return ans;
    }
}

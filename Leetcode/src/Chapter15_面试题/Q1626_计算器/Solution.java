package Chapter15_面试题.Q1626_计算器;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/12/2020 23:49
 **/

public class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int i = 0,ans = 0;
        //用栈来保存每次处理后的结果
        Stack <Integer> stack = new Stack<>();
        while(i < chars.length){
            //去除表达式中无用的空格
            if(chars[i] == ' '){
                i++;
                continue;
            }
            //查看是否是符号
            char tmp = chars[i];
            if(tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/'){
                //处理下一个字符，找到下一个要计算的数字
                i++;
                //去除后缀的空格
                while(i < chars.length && chars[i] == ' '){
                    i++;
                }
            }
            //计算下一个数字
            int num = 0;
            while(i < chars.length && Character.isDigit(chars[i])){
                num = num * 10 + chars[i] - '0';
                i++;
            }
            //判断符号
            switch(tmp) {
                //因为统一将要求和的内容爆保存在栈里
                case '-' :
                    num = - num;
                    break;
                //有限计算乘积
                case '*' :
                    num = stack.pop() * num;
                    break;
                //计算除后结果
                case '/' :
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            //保存结果
            stack.push(num);
        }
        //对栈里面的数据求和得到最后结果
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}

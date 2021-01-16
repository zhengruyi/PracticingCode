package Chapter14_深度搜索和广度搜索.Q241_为运算表达式设计优先级;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 19:05
 **/

public class Solution {
    /**
     * 本题的主要思路就是分治算法，遇到计算符号就分成两段，相当于用括号把字符串分成两部分
     * 两部分在用同样的方法来求得所有的可能计算的值,把这些值用符号组合在一起就是最终的结果
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList <>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            //遇到符号进行切分
            if(c == '+' || c == '-' || c == '*'){
                //分治算法处理左右字符串,分治的思想就是一个运算符，一个运算符去试
                //每次都相当于用括号把运算符两边包裹起来后执行运算
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List <Integer> right = diffWaysToCompute(input.substring(i+1));
                //将左右字符串的结果用运算符组合在一起就是最终的结果
                for(int l : left){
                    for(int r : right){
                        if( c== '+'){
                            res.add(l + r);
                        }else if( c =='*'){
                            res.add(l * r);
                        }else if(c == '-'){
                            res.add( l - r);
                        }
                    }
                }
            }

        }
        //如果列表为空，说明字符串中没有计算符，那么当前字符串就是代表一个单独的数字
        //把数字处理一下，放入空列表返回就可以
        if(res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}

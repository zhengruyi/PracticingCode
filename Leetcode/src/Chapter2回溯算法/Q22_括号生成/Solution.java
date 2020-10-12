package Chapter2回溯算法.Q22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 14:31
 **/

public class Solution {
    /**
     * 当用回溯算法时，有多个选择时，则可以把所有选择都过一遍
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List <String> res = new ArrayList <String>();
        StringBuilder builder = new StringBuilder();
        backTrack(n,n,builder,res);
        return res;
    }
    public void backTrack(int left, int right, StringBuilder builder, List<String> res){
        //合法的括号序列要求左括号数目大于右括号，所以当剩余左括号数目大于右括号时不合法，直接返回
        if(left > right){
            return;
        }
        //防止一直填左括号引起栈溢出
        if(left < 0 || right < 0){
            return;
        }
        //当左右括号都用完时，则是一个正确解，可以加入答案列表中
        if(left == 0 && right == 0){
            res.add(builder.toString());
        }
        //尝试添加左括号
        builder.append('(');
        backTrack(left - 1, right,builder,res);
        builder.deleteCharAt(builder.length()-1);
        //尝试添加右括号
        builder.append(')');
        backTrack(left,right-1,builder,res);
        builder.deleteCharAt(builder.length()-1);
    }
}

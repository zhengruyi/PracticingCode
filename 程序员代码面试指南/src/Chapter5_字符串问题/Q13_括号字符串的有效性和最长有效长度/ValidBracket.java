package Chapter5_字符串问题.Q13_括号字符串的有效性和最长有效长度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/06/2020 22:34
 **/

public class ValidBracket {
    public boolean isValid(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack <>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '('){
                stack.push(chars[i]);
            }else if(chars[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }else {
                return false;
            }
        }
        return  stack.isEmpty();
    }
    public int maxLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if(chas[i] == ')'){
                pre = i - dp[i-1] -1;
                if(pre >=0 && chas[pre] == '('){
                    dp[i] = dp[i-1] +2 +(pre > 0 ? dp[pre -1] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    @Test
    void test(){
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("(()())"));
        Assertions.assertTrue(isValid("(())"));
        Assertions.assertFalse(isValid("((())"));
        Assertions.assertFalse(isValid("()())"));
    }

    @Test
    void test1(){
        Assertions.assertEquals(6,maxLength("(()())"));
        Assertions.assertEquals(2,maxLength("())"));
        Assertions.assertEquals(4,maxLength("()(()()("));
    }
}

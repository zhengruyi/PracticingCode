package Chapter5_字符串问题.Q1_判断两个字符串是否互为变形词;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/06/2020 21:39
 **/

public class CompareStrings {
    public boolean compare(String s1,String s2){
        if(s1 == null || s2 == null){
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)] ++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if(chars[s2.charAt(i)] == 0){
                return false;
            }
            chars[s2.charAt(i)]--;
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] > 0){
                return false;
            }
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertTrue(compare("123","321"));
        Assertions.assertTrue(compare("12ACBF3","321BCAF"));
        Assertions.assertFalse(compare("123","2331"));
    }
}

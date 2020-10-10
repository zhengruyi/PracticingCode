package Chapter5_字符串问题.Q5_将整数字符串转成整数值;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 13:44
 **/

public class Transform {
    public int transform(String s){
        if(s == null || s.length() == 0){
            throw  new RuntimeException();
        }
        long num = 0;
        boolean positive = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-'){
                positive = false;
            }else if(c >= '0' && c <= '9'){
                if(c == '0' && num == 0){
                    return 0;
                }
                int tmp = c - '0';
                num = num * 10 + (positive ? tmp : tmp * -1);
                if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
                    return 0;
                }
            }
            else{
                return (int) num;
            }
        }
        return (int) num;
    }

    @Test
    void test(){
        Assertions.assertEquals(123,transform("123"));
        Assertions.assertEquals(0,transform("023"));
        Assertions.assertEquals(0,transform("A13"));
        Assertions.assertEquals(0,transform("0"));
        Assertions.assertEquals(2147483647,transform("2147483647"));
        Assertions.assertEquals(0,transform("2147483648"));
        Assertions.assertEquals(-123,transform("-123"));
    }
}

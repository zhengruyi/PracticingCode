package Chapter5_字符串问题.Q2_字符串中数字子串的求和;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/06/2020 22:04
 **/

public class SubstringSum {
    public int getSum(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean positive = true;
        int res = 0;
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (curr >='0' && curr <= '9'){
                int tmp = curr - '0';
                num = num * 10 + (positive ? tmp : tmp * -1);
            }else if(curr == '-'){
                if(i-1 > -1 && chars[i-1] == '-'){
                    positive = !positive;
                }else{
                    positive = false;
                }

            }else{
                res += num;
                num = 0;
                positive = true;
            }
        }
        res += num;
        return res;
    }
    @Test
    void test(){
        Assertions.assertEquals(36,getSum("A1CD2E33"));
        Assertions.assertEquals(7,getSum("A-1B--2C--D6E"));
        Assertions.assertEquals(7,getSum("A-1B--2C-D6E"));
        Assertions.assertEquals(-5,getSum("A-1B--2C-D-6E"));
    }
}

package Chapter0_其他.Q43_字符串相乘;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/10/2020 18:11
 **/

public class Solution {
    public String multiply(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int [] res = new int[ch1.length+ch2.length];
        int mul = 0;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        for(int i = ch1.length -1; i >= 0;  i--){
            for(int j = ch2.length - 1; j >=0 ;j--){
                mul = (ch1[i] - '0') * (ch2[j] - '0');
                p1 = i+j;
                p2 = i+j +1;
                //求出个位和乘积的和用来更新数组
                sum = mul + res[p2];
                res[p2] = sum %10;
                res[p1] += sum /10;
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for(int num : res){
            if(num != 0 || flag){
                flag = true;
                builder.append(num);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();

    }
    @Test
    void test(){
        Assertions.assertEquals("56088",multiply("123","456"));
    }
}

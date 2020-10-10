package Chapter5_字符串问题.Q3_去掉字符串中连续出现的k个0的子串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 10:30
 **/

public class DeleteZeros {
    public String delete(String s ,int k){
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                start = start == -1 ? i : start;
                count++;
            }else{
                if(count >0 && count != k){
                    while (start < i){
                        builder.append(s.charAt(start));
                        start++;
                    }
                }
                builder.append(s.charAt(i));
                start = -1;
                count = 0;
            }
        }
        if(count  >0 && count != k){
            while (start < s.length()){
                builder.append(s.charAt(start));
                start++;
            }
        }
        return builder.toString();
    }
    @Test
    void test(){
        Assertions.assertEquals("A00B",delete("A00B",3));
        Assertions.assertEquals("A0000B",delete("A0000B000",3));
        Assertions.assertEquals("AB000",delete("A0000B000",4));
    }
}

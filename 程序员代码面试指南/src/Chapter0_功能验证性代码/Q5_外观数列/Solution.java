package Chapter0_功能验证性代码.Q5_外观数列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/07/2020 11:12
 **/

public class Solution {
    public String countAndSay(int n) {
        if(n < 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('1');
        int i = 1;
        StringBuilder temp = new StringBuilder();
        while (i < n){
            int start = 0;
            int count = 0;
            int index = 0;
            int length = builder.length();
            while (index < length){
                if(builder.charAt(index) == builder.charAt(start)){
                    count++;
                }else{
                    temp.append(count);
                    count = 1;
                    temp.append(builder.charAt(start));
                    start = index;
                }
                index++;
            }
            if(index == length  && count != 0){
                temp.append(count);
                temp.append(builder.charAt(start));
            }
            builder.delete(0,length);
            builder.append(temp.toString());
            temp.delete(0,temp.length());
            i++;
        }
        return builder.toString();
    }
    @Test
    void test(){
        Assertions.assertEquals("111221",countAndSay(5));
    }
}

package Chapter5_字符串问题.Q6_替换字符串中连续出现的指定字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 19:58
 **/

public class ReplaceString {
    public String replace(String s, String from, String to) {
        if (s == null || s.length() == 0 || from == null || to == null) {
            return null;
        }
        char[] arr = s.toCharArray();
        int match = 0;
        int len = from.length();
        for (int i = 0; i < arr.length; i++) {
            if (from.charAt(match) == arr[i]) {
                match++;
                if (match == from.length()) {
                    clean(arr,i,len);
                    match = 0;
                }
            } else {
                if(arr[i] == from.charAt(0)){
                    match = 1;
                }else{
                    match = 0;
                }

            }
        }
        StringBuilder builder = new StringBuilder();
        boolean founded = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '0'){
                if(!founded){
                    builder.append(to);
                    founded = true;
                }
            }else{
                founded = false;
                builder.append(arr[i]);
            }
        }
        return  builder.toString();
    }

    public void clean(char[] arr, int end, int length) {
        for (int i = end - length+1; i <= end; i++) {
            arr[i] = '0';
        }
    }
    @Test
    void test(){
        //Assertions.assertEquals("1234567",replace("123abc","abc","4567"));
        //Assertions.assertEquals("123",replace("123","abc","456"));
        Assertions.assertEquals("123XabX",replace("123abcabcababc","abc","X"));
    }
}

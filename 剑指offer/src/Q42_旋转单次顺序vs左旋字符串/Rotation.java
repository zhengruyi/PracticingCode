package Q42_旋转单次顺序vs左旋字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 17:38
 **/

public class Rotation {
    public String rotateWordsOrder(String s){
        if(s == null || s.length() == 0)
            return null;
        char[] origin = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for (int i = origin.length - 1; i >= 0; i--) {
            if(origin[i] != ' '){
                temp.append(origin[i]);
            }else{
                if(temp.length() > 0){
                    buffer.append(temp.reverse());
                    temp.delete(0,temp.length());
                }
                buffer.append(' ');
            }
        }
        buffer.append(temp.reverse());
        return buffer.toString();
    }

    public String rotateLeftWordOrder(String s, int n){
        if(s == null || s.length() == 0 || n > s.length() || n < 0)
            return null;
        char[] origin = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for (int i = origin.length - 1; i >= 0; i--) {
            if(i >= n){
                temp.append(origin[i]);
            }else{
                if(i == n-1){
                    buffer.append(temp.reverse());
                    temp.delete(0,temp.length());
                }
                temp.append(origin[i]);
            }
        }
        return buffer.append(temp.reverse()).toString();
    }


    @Test
    void test(){
        Assertions.assertEquals("student. a am I",rotateWordsOrder("I am a student."));
        Assertions.assertEquals("cdefgab", rotateLeftWordOrder("abcdefg",2));
    }
}

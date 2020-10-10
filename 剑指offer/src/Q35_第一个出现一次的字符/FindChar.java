package Q35_第一个出现一次的字符;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 11:54
 **/

public class FindChar {
    public char find(String s){
        if(s == null || s.length() == 0)
            throw  new RuntimeException();

        char[] chars = s.toCharArray();
        int[] times = new int[256];
        for(int i= 0; i < chars.length; i++)
            times[(int)chars[i]]++;
        int i = 0;
        for (i = 0; i < chars.length; i++) {
            if(times[(int)chars[i]] == 1)
                return chars[i];
        }
        if(i == chars.length)
            throw new RuntimeException("No chars appear once");
        return '!';
    }

    @Test
    void test(){
        Assertions.assertEquals('b',find("abaccdeff"));
        Assertions.assertThrows(Exception.class, ()->find("aabb"));
        Assertions.assertEquals('c',find("cba"));
    }
}

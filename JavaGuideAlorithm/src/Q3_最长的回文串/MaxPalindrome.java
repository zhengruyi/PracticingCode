package Q3_最长的回文串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/05/2020 22:22
 **/

public class MaxPalindrome {
    public int getMaxPalindrome(String s){
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet <>();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if(set.contains(chars[i])){
                length+=2;
                set.remove(chars[i]);
            }
            else {
                set.add(chars[i]);
            }
        }
        if(set.size() >0 )
            return length+1;
        else
            return length;
    }
    @Test
    void test(){
        Assertions.assertEquals(7,getMaxPalindrome("abccccdd"));
        Assertions.assertEquals(6,getMaxPalindrome("abcbac"));
    }
}

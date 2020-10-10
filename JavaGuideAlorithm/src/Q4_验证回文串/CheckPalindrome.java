package Q4_验证回文串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/05/2020 22:28
 **/

public class CheckPalindrome {
    public boolean checkPalindrome(String s) {
        if(s == null)
            return false;
        if(s.length() == 0)
            return true;

        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start <= end){
            while (!((chars[start] >= 'a' && chars[start] <= 'z')|| (chars[start] >= '0' && chars[start] <= '9')) && start < end)
                start++;
            while (!((chars[end] >= 'a' && chars[end] <= 'z')|| (chars[end] >= '0' && chars[end] <= '9')) && start < end)
                end -- ;
            if(chars[start] == chars[end]){
                if(start == end || end == start + 1)
                    return true;
                start++;
                end--;
            }else{
                return false;
            }
        }
        return false;
    }
    @Test
    void test(){
        Assertions.assertTrue(checkPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(checkPalindrome("race a car"));
    }
}

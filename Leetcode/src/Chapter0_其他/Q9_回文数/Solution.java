package Chapter0_其他.Q9_回文数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 20:16
 **/

public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}

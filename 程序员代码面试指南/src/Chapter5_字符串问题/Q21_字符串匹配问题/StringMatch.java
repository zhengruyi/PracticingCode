package Chapter5_字符串问题.Q21_字符串匹配问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/06/2020 15:35
 **/

public class StringMatch {

    public boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = str.toCharArray();
        return isValid(s, e) && process(s, e, 0, 0);
    }

    public boolean process(char[] s, char[] e, int si, int ei) {
        //ei 到了最后一个字符，要求si也到了最后一个字符
        if (ei == e.length) {
            return si == s.length;
        }
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (e[ei] == s[si] || e[ei] == '.')
                    && process(s, e, si + 1, ei + 1);
        }
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }

    public boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        Assertions.assertTrue(isMatch("abc", "abc"));
        Assertions.assertTrue(isMatch("abc", "a.c"));
        Assertions.assertTrue(isMatch("abcd", ".*"));
    }
}

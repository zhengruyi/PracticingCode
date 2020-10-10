package Chapter4_递归和动态规划.Q12_数字字符串转换成字母组合的种数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/06/2020 15:05
 **/

public class TransferNumbers {
    public int getTransferNumbers(String origin) {
        if (origin == null || origin.length() == 0) {
            return 0;
        }
        return process(origin, 0);
    }

    public int process(String origin, int index) {
        if (index == origin.length()) {
            return 1;
        }
        if (origin.charAt(index) == '0') {
            return 0;
        } else if (origin.charAt(index) > '0' && origin.charAt(index) <= '9') {
            int res = process(origin, index + 1);
            if (index + 1 < origin.length()) {
                int next = (origin.charAt(index) - '0') * 10 + origin.charAt(index + 1) - '0';
                if (next >= 10 && next <= 26) {
                    res += process(origin, index + 2);
                }
            }
            return res;
        }
        return 0;
    }

    public int getTransferNumberWithDP(String origin) {
        if (origin == null || origin.length() == 0) {
            return 0;
        }
        char[] chs = origin.toCharArray();
        int curr = chs[chs.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = chs.length - 2; i >= 0; i--) {
            if (chs[i] == '0') {
                next = curr;
                curr = 0;
            } else {
                tmp = curr;
                if (((chs[i] - '0') * 10 + chs[i + 1] - '0') < 27) {
                    curr += next;
                }
                next = tmp;
            }
        }
        return curr;
    }

    @Test
    void test() {
        Assertions.assertEquals(5, getTransferNumbers("1111"));
        Assertions.assertEquals(0, getTransferNumbers("01"));
        Assertions.assertEquals(1, getTransferNumbers("10"));
    }

    @Test
    void testDP() {
        Assertions.assertEquals(5, getTransferNumberWithDP("1111"));
        Assertions.assertEquals(0, getTransferNumberWithDP("01"));
        Assertions.assertEquals(1, getTransferNumberWithDP("10"));
    }
}

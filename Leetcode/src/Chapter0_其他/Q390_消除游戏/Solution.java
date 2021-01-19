package Chapter0_其他.Q390_消除游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:12
 **/

public class Solution {
    /**
     * 这道题目重点在于推导数学递推公式,由于奇数部分会在第一次遍历后删除
     * 所以剩下的偶数部分在反向编号就会发现f(2k) = 2*(k + 1 - f(k))
     * 再结合奇偶性就会发现这个公式对于奇偶数都一样
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2*(n/2 + 1 - lastRemaining(n/2));
    }
}

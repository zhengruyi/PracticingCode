package Chapter0_其他.Q461_汉明距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/01/2021 20:13
 **/

public class Solution {
    /**
     * 异或会将相同位置变成0,不同位置变成1，后续统计有多少位是数字1
     * 这里用到的方法是Integer.bitCount(),也可以用n & (n - 1)这会将最右边的数位1
     * 变成0
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

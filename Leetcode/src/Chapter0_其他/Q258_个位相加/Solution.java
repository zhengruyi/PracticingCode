package Chapter0_其他.Q258_个位相加;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:25
 **/

public class Solution {
    /**
     * x * 100 + y *10 + z = x * 99 + y * 9 + z +x + y +z
     * 但如果直接对9取余会导致把和为9的数字变成0，所以这里先减去1再加上1
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}

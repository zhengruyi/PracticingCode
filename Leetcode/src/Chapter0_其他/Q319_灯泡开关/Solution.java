package Chapter0_其他.Q319_灯泡开关;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/10/2020 13:03
 **/

public class Solution {
    //除了平方根之外的数字都会执行偶数次开关，所以最后还开着的是sqrt(n)
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}

package Chapter0_其他.Q365_水壶问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 19:13
 **/

public class Solution {
    /**
     z = ax + by,当且仅当z是x和y的最小公约数的倍数时存在解
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z){
            return false;
        }
        if(x == 0 || y == 0){
            return z == 0 || x + y == z;
        }
        return z % gcd(x,y) == 0;
    }

    /**
     * 旋转相除法来求最小公约数
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y){
        int remainder = x % y;
        while(remainder != 0){
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}

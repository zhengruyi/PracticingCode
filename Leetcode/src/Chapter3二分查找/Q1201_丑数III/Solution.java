package Chapter3二分查找.Q1201_丑数III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:51
 **/

public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int min = Math.min(a,Math.min(b,c));
        int left = 0;
        int right = min * n;
        //注意最小公倍数可能会溢出
        long ab = lcm(a,b);
        long bc = lcm(b,c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);
        //二分法搜索丑数
        while(left <= right){
            int mid = left + (right - left) /2;
            //解释看图:https://leetcode-cn.com/problems/ugly-number-iii/solution/xiang-dao-er-fen-fa-cheng-gong-yi-da-ban-by-bloodb/
            long num = mid/a + mid/b + mid/c - mid/ab - mid/bc - mid/ac + mid/abc;
            //如果当前mid恰好是第n个丑数且当前Mid可以整除a，b,c中的一个。那么就直接返回
            if(num == n){
                if(mid % a == 0 || mid %b == 0 || mid % c == 0){
                    return mid;
                    //往左收缩找到真正的边界
                }else{
                    right = mid - 1;
                }
                //目标丑数在左边
            }else if(num > n){
                right = mid - 1;
                //目标丑数在右边
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }

    /**
     * 计算最小公倍数
     * @param x
     * @param y
     * @return
     */
    public long lcm(long x, long y){
        return x * y /gcd(x,y);
    }

    /**
     * 计算最大公约数
     * @param x
     * @param y
     * @return
     */
    public long gcd(long x, long y){
        long remainder = x % y;
        while(remainder != 0){
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}

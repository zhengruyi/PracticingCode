import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        nthUglyNumber(14,3,7,13);
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int min = Math.min(a,Math.min(b,c));
        int left = 0;
        int right = min * n;
        long ab = lcm(a,b);
        long bc = lcm(b,c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);
        while(left <= right){
            int mid = left + (right - left) /2;
            long num = mid/a + mid/b + mid/c - mid/ab - mid/bc - mid/ac + mid/abc;
            if(num == n){
                if(mid % a == 0 || mid %b == 0 || mid % c == 0){
                    return mid;
                }else{
                    right = mid - 1;
                }
            }else if(num > n){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
    public long lcm(long x, long y){
        return x * y /gcd(x,y);
    }
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

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
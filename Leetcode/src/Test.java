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
        int[] nums = {1,2,1,3,2,5};
        numWays(7);
    }
    public int numWays(int n) {
        int ans = 0;
        int mod = 1_000_000_000 + 7;
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 1;
        }else{
            int i = 2;
            int p1 = 1;
            int p2 = 1;
            while(i <= n){
                ans = p1 + p2;
                i++;
                ans = ans % mod;
                p1 = ans;
                p2 = p1;
            }
            return ans;
        }
    }

}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
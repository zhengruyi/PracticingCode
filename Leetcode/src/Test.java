import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        minimumOperations("rrryyyrryyyrr");
    }

    public static void main(String[] args) {
        Integer[] tmp = {1,2,3};
        List<Integer> list = Arrays.asList(tmp);
    }
    public int minimumOperations(String leaves) {
        int length = leaves.length();
        int[][] dp = new int[3][length];
        for(int i = 0; i < length; i++){
            if(i < 1){
                dp[0][i] = leaves.charAt(i) == 'r' ? 0 : 1;
            }else{
                dp[0][i] = dp[0][i-1] + leaves.charAt(i) == 'r' ? 0 : 1;
            }

            if(i < 1){
                dp[1][i] = dp[0][i];
            }else{
                dp[1][i] = Math.min(dp[1][i-1] + leaves.charAt(i) == 'y' ? 0 : 1, dp[0][i-1] + leaves.charAt(i) == 'y' ? 0 : 1);
            }
            if(i < 2){
                dp[2][i] = dp[1][i];
            }else{
                dp[2][i] = Math.min(dp[2][i-1] + leaves.charAt(i) == 'r' ? 0 : 1, dp[1][i-1] + leaves.charAt(i) == 'r' ? 0 : 1);
            }
        }
        return dp[2][length-1];
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
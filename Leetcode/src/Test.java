import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return res;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for(int i = 0;i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(j-1 >= 0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i-1 >= 0){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        if(dp[rows-1][cols-1] == 0){
            return res;
        }
        int x = rows-1;
        int y = cols-1;
        while(x != 0 && y != 0){
            if((x - 1 >= 0 && dp[x-1][y] > 0) || (y-1 >= 0 && dp[x][y-1] > 0)){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(x);
                tmp.add(y);
                res.addFirst(tmp);
                if(x - 1 >= 0 && dp[x-1][y] > 0){
                    x--;
                }else{
                    y--;
                }
            }
        }
        return res;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        pathWithObstacles(matrix);
    }

    public static void main(String[] args) {
        String s = "/a/../../b/../c//.//";
        String[] str = s.split("/");
        System.out.println(s);
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

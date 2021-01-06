import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    num++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(num == 0){
            return 0;
        }
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            time++;
            for(int i = 0; i < dx.length; i++){
                int newX = position[0] + dx[i];
                int newY = position[1] + dy[i];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                    queue.offer(new int[] {newX,newY});
                    grid[newX][newY] = 2;
                    num--;
                }
            }
            if(num == 0){
                return time;
            }
        }
        return num == 0 ? time : -1;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[][] nums = {{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6,9};
        System.out.println(Arrays.binarySearch(nums,10));
    }

}
class UnionFindSet{
    private int[] parents;
    private int[] ranks;
    public UnionFindSet(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    public int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return true;
        }
        if(ranks[x] < ranks[y]){
            parents[rootX] = rootY;
        }else if(ranks[y] < ranks[x]){
            parents[rootY] = rootX;
        }else{
            parents[rootX] = rootY;
            ranks[x]++;
        }
        return false;
    }
}
import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0){
            return new int[]{0,0};
        }
        int n = edges.length + 1;
        UnionFindSet set = new UnionFindSet(n);
        for(int[] edge : edges){
            if(set.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{0,0};
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[][] nums = {{1,2},{1,3},{2,3}};
        findRedundantConnection(nums);
    }

    public static void main(String[] args) {
        String s = "a b c";
        System.out.println(s.split(" ")[0]);
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
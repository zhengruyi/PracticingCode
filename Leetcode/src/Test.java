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
        int[][] graph = {{1}, {0,3}, {3}, {1,2}};
        isBipartite(graph);
    }

    public static void main(String[] args) {
        System.out.println("\t".length());
    }
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0 || graph[0].length == 0){
            return true;
        }
        int len = graph.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(res[graph[i][j]] == 0){
                    res[graph[i][j]] = -1 *res[i];
                }else if(res[graph[i][j]] != -1 *res[i]){
                    return false;
                }
            }
        }
        return true;
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
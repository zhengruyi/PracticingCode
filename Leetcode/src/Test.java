import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < popped.length; i++){
            if(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                continue;
            }
            while(index < pushed.length && pushed[index] != popped[i]){
                stack.push(pushed[index++]);
            }
        }
        return stack.isEmpty();
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] n1 = {1,2,3,4,5};
        int[] n2 = {4,5,3,2,1};
        validateStackSequences(n1,n2);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

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
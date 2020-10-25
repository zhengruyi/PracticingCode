package Chapter9_并查集.Q990_等式方程的可满足性;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/10/2020 17:16
 **/

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for(String e : equations){
            if(e.charAt(1) == '='){
                uf.union(e.charAt(0)-'a', e.charAt(3) - 'a');
            }
        }
        for(String e : equations){
            if(e.charAt(1) == '!'){
                if(uf.connected(e.charAt(0) - 'a', e.charAt(3) - 'a')){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertFalse(equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
    }
}
class UF{
    private int count;
    private int[] size;
    private int[] parent;
    public UF(int n){
        size = new int[n];
        parent = new int[n];
        count = n;
        for(int i =0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty){
            return;
        }
        if(size[rootx] < size[rooty]){
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        }else{
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }
        count--;
    }
    public int count(){
        return count;
    }
    public boolean connected(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        return rootx == rooty;
    }
}

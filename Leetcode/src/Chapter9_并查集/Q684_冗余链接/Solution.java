package Chapter9_并查集.Q684_冗余链接;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/01/2021 22:51
 **/

public class Solution {
    /**
     * 主要用并查集来快速查找两个节点是否相连
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0){
            return new int[]{0,0};
        }
        int n = edges.length + 1;
        UnionFindSet set = new UnionFindSet(n);
        for(int[] edge : edges){
            //如果两个节点已经相连，那么这条边就是最终的冗余边
            if(set.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{0,0};
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

    /**
     * 赌鬼方式查找根节点，同时压缩路径
     * @param x
     * @return
     */
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

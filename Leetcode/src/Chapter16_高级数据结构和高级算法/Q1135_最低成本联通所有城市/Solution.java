package Chapter16_高级数据结构和高级算法.Q1135_最低成本联通所有城市;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/03/2021 23:24
 **/

public class Solution {
    /**
     * 使用的是Kruskal生成的最小生成树,即每次在所有已连接和未连接的两组中,取出距离最短的一条线
     * 用来将节点连接起来,这里对两两节点间的距离进行排序,然后用并查集检查节点之间的连接性,如果没有连接
     * 就把两个节点连接一下,统计总共的损耗,如果已经连接则可以直接忽略.
     * @param N
     * @param connections
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections,(a,b) -> a[2] - b[2]);
        UnionSet set = new UnionSet(N+1);
        int res = 0;
        for(int[] connection : connections){
            if(set.union(connection[0],connection[1])){
                res += connection[2];
            }
        }
        return set.getParentCount() > 1 ? -1 : res;
    }
}
class UnionSet{
    int[] parent;
    int[] rank;
    int countParent;
    public UnionSet(int n){
        parent = new int[n];
        rank = new int[n];
        countParent = n - 1;
        for(int i = 1; i < n; i++){
            parent[i] = i;
        }
        Arrays.fill(rank,1);
    }
    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY){
            return false;
        }
        if(rank[parentX] < rank[parentY]){
            int temp = parentX;
            parentX = parentY;
            parentY = temp;
        }
        parent[parentY] = parentX;
        countParent--;
        if(rank[parentX] == rank[parentY]){
            rank[parentX]++;
        }
        return true;
    }
    public int getParentCount(){
        return this.countParent;
    }
}
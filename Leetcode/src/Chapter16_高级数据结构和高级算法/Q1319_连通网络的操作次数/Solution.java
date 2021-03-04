package Chapter16_高级数据结构和高级算法.Q1319_连通网络的操作次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/03/2021 23:26
 **/

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        Djset set = new Djset(n);
        //将连接关系输入并查集
        for(int[] connect : connections){
            set.merge(connect[0],connect[1]);
        }
        //当有n个连通分量时，至少要n-1个链接才能将全部连通分量合并到一起
        if(set.getRest() < set.getCount() - 1){
            return -1;
        }
        //连通分量的个数减去1就是最少的操作次数
        return set.getCount() - 1;
    }
}
class Djset{
    int count;
    int rest;
    int[] parent;
    int[] rank;
    public Djset(int len){
        parent = new int[len];
        for(int i = 0; i < len; i++){
            parent[i] = i;
        }
        rank = new int[len];
        count = len;
        rest = 0;
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void merge(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY){
            if(rank[parentX] < rank[parentY]){
                int temp = parentY;
                parentY = parentX;
                parentX = parentY;
            }
            parent[parentX] = parentY;
            if (rank[parentX] == rank[parentY]){
                rank[parentX] += 1;
            }
            //连通分量合并,总数目减去1
            count--;
        }else{
            //多余的连接数加1
            rest++;
        }
    }
    public int getCount(){
        return this.count;
    }
    public int getRest(){
        return this.rest;
    }
}
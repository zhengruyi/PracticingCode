package Chapter9_并查集.Q947_移除最多的同行或同列石头;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/02/2021 22:03
 **/

public class Solution {
    /**
     * 同行同列的所能移除的最大数目的石头等于总的石头数目,再减去输入所有石头后的联通量的数目
     *
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for(int[] stone : stones){
            unionFind.union(stone[0] + 10001,stone[1]);
        }
        return stones.length - unionFind.getCount();
    }
}

/**
 * 用来计算并查集的联通量数目
 */
class UnionFind{

    Map <Integer,Integer> parent;
    int count;

    public UnionFind(){
        count = 0;
        //用来连接子节点和父节点的哈希表
        parent = new HashMap();
    }

    public int getCount(){
        return this.count;
    }

    public int find(int x){
        //当父节点不存在时,那么就是一个新的连通分量总数加1
        if(!parent.containsKey(x)){
            parent.put(x,x);
            count++;
        }
        //压缩路劲，将x的父节点设置成当前连通分量的顶点
        if(x != parent.get(x)){
            parent.put(x,find(parent.get(x)));
        }
        return parent.get(x);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }
        //连接两个连通分量,因为这两个点本就是一个坐标
        parent.put(rootX,rootY);
        count--;
    }
}
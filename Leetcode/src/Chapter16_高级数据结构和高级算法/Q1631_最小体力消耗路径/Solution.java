package Chapter16_高级数据结构和高级算法.Q1631_最小体力消耗路径;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/03/2021 23:34
 **/

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int start = 0;
        //将二维矩阵压缩到一维数组
        int end = m * n - 1;
        //创建并查集
        Djset set = new Djset(m * n);
        List <Edge> edges = new ArrayList();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //计算起点坐标
                int curr = i * n + j;
                //和左边相邻的点构成一条边
                if(j - 1 >= 0){
                    int left = curr - 1;
                    Edge e = new Edge(curr,left,Math.abs(heights[i][j] - heights[i][j-1]));
                    edges.add(e);
                }
                //和上边的点构成的边
                if(i - 1 >= 0){
                    int up = (i-1) * n + j;
                    Edge e = new Edge(curr,up,Math.abs(heights[i][j] - heights[i-1][j]));
                    edges.add(e);
                }
            }
        }
        //边按照距离从小到大进行排序
        Collections.sort(edges, (o1, o2) -> o1.dist - o2.dist);
        int index = 0;
        int res = 0;
        //跳出条件是左上和右下的起点和终点想通
        while(!set.connect(start,end)){
            Edge e = edges.get(index++);
            //将两个点连接到一起
            set.merge(e.i,e.j);
            //最大的消耗
            res = e.dist;
        }
        return res;
    }
}

/**
 * i,j表示起始点,dist表示距离
 */
class Edge{
    public int i;
    public int j;
    public int dist;
    public Edge(int i, int j,int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}

/**
 * 并查集
 */
class Djset{
    int[] parent;
    int[] rank;
    public Djset(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
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
                int temp = parentX;
                parentX = parentY;
                parentY = temp;
            }
            parent[parentX] = parentY;
            if(rank[parentX] == rank[parentY]){
                rank[parentX] += 1;
            }
        }
    }
    public boolean connect(int x, int y){
        return find(x) == find(y);
    }
}
package Chapter16_高级数据结构和高级算法.Q1584_连接所有点的最小费用;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/03/2021 23:25
 **/

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        //保存最小生成树的节点到集合中的节点的最短距离
        int[] lowCost = new int[len];
        int res = 0;
        Arrays.fill(lowCost,Integer.MAX_VALUE);
        //初始将0点放入最小生成树
        lowCost[0] = 0;
        int checkPoint = 0;
        //n个节点需要n-1条边将节点连接起来,所以运行n-1次
        for(int i = 0; i < len - 1; i++){
            //初始化变量
            int temp = checkPoint;
            int minDist = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                //lowCost[j] == 0代表这个点在最小生成树中
                if(lowCost[j] > 0){
                    //跟新集合中的点到最小生成树的距离
                    lowCost[j] = Math.min(lowCost[j],manhaton(points,j,checkPoint));
                    //跟新最短距离的对应的点
                    if(lowCost[j] < minDist){
                        temp = j;
                        minDist = lowCost[j];
                    }
                }
            }
            //将这个点放入最小生成树
            checkPoint = temp;
            //从集合中删除这个点
            lowCost[temp] = 0;
            //计算总消耗
            res += minDist;
        }
        return res;
    }
    public int manhaton(int[][] points, int x, int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}

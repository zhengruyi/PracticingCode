package Chapter2_贪心算法.Q4_图的最小生成树;

import javax.management.StandardEmitterMBean;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/07/2020 14:25
 **/

public class MinimumTree {
    /**
     * 最小生成树就是用来找最短的路劲和来把途中的各个节点连接在一起
     * @param graph
     * @param nums
     * @param start
     */
    public static void miniTree(int[][] graph, int nums, int start){
        int max = Integer.MAX_VALUE;
        int[] closest = new int[nums];
        int[] lowClosest = new int[nums];
        boolean[] used = new boolean[nums];
        for (int i = 0; i < nums; i++) {
            if(start == i){
                lowClosest[i] = 0;
            }else{

                lowClosest[i] = graph[start][i];
            }
            closest[i] = start ;
        }
        used[start] = true;
        for (int i = 0; i < nums; i++) {
            int temp = max;
            int minIndex = start;
            for (int j = 0; j < lowClosest.length; j++) {
                if(!used[j] && temp > lowClosest[j]){
                    minIndex = j;
                    temp = lowClosest[j];
                }
            }
            if(minIndex == start){
                break;
            }
            used[minIndex] = true;
            for (int j = 0; j < nums; j++) {
                if(!used[j] && graph[minIndex][j] < lowClosest[j]){
                    closest[j] = minIndex;
                    lowClosest[j] = graph[minIndex][j];
                }
            }
        }
        for (int i = 0; i < nums; i++) {
            System.out.println(lowClosest[i]);
        }

    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] graph = {
                {m,23,m,m,m,28,36},
                {23,m,20,m,m,m,1},
                {m,20,m,15,m,m,4},
                {m,m,15,m,3,m,9},
                {m,m,m,3,m,17,16},
                {28,m,m,m,17,m,25},
                {36,1,4,9,16,25,m}
        };
        miniTree(graph,7,0);
    }

}

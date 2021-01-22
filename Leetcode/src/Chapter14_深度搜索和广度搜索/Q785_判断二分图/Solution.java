package Chapter14_深度搜索和广度搜索.Q785_判断二分图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:51
 **/

public class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;

    /**
     * 这里的方法就是采用涂色的方法，看能不能给每个节点都能图上满意的颜色
     * 使得相邻的节点的颜色不等
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] res = new int[len];
        //这里的终点就是对节点进行遍历保证所有节点都会涂上颜色
        for(int i = 0; i < len; i++){
            //如果节点没有涂色，那么就从这个节点开始进行广度遍历
            if(res[i] == UNCOLORED){
                Queue <Integer> queue = new LinkedList <Integer>();
                queue.offer(i);
                res[i] = RED;
                //基本逻辑就是邻居节点没有上色那么就图上相反的颜色
                //如果已经有颜色，那么判断颜色存不存在冲突，存在冲突就返回false
                while(!queue.isEmpty()){
                    int index = queue.poll();
                    int c = res[index] == RED ? GREEN : RED;
                    for(int neighbor : graph[index]){
                        if(res[neighbor] == UNCOLORED){
                            res[neighbor] = c;
                            queue.offer(neighbor);
                        }else if(res[neighbor] != c){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}

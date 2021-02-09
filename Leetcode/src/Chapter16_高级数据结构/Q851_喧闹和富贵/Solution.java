package Chapter16_高级数据结构.Q851_喧闹和富贵;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/02/2021 19:59
 **/

public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        //记录节点的入度
        int[] inDegree = new int[len];
        //构建有向图
        List<List <Integer>> graph = new ArrayList <>();
        //创建空的图
        for(int i = 0; i < len; i++){
            graph.add(new ArrayList<>());
        }
        Queue <Integer> queue = new LinkedList <>();
        //将当前有向边按照起点进行分类,并且将终点的入度加1
        for(int[] rich : richer){
            graph.get(rich[0]).add(rich[1]);
            inDegree[rich[1]] ++;
        }
        int[] res = new int[len];
        //初始情况将所有点的较富裕且安静的点设置成自己
        for(int i = 0; i < len; i++){
            //按照拓扑排序,将所有入度为0的起始点放入队列中
            if(inDegree[i] == 0){
                queue.offer(i);
            }
            res[i] = i;
        }
        //宽度遍历
        while(!queue.isEmpty()){
            int id = queue.poll();
            //获取比当前点的安静且富裕的节点，默认是自己
            int quiteVal = quiet[res[id]];
            for(int neighbor : graph.get(id)){
                //检查自己的终点的安静值是否小于自己,如果是就赋值比自己富裕且安静的值
                if(quiteVal < quiet[res[neighbor]]){
                    res[neighbor] = res[id];
                }
                //将终点的入度减去1，如果入度减成0就将这个点入队列
                if(--inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return res;
    }
}

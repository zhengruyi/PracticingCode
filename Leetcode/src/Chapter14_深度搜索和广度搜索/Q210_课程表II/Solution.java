package Chapter14_深度搜索和广度搜索.Q210_课程表II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 23:20
 **/

public class Solution {
    /**
     * 拓扑排序，常用于将有向无环图按照依赖关系遍历出来,即保证所有依赖项都遍历完后，才会遍历本体
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List <Integer>> graph = new ArrayList <>();
        List<Integer> res = new ArrayList<>();
        //记录每个节点的入度的数组
        int[] inDegree = new int[numCourses];
        //创建邻接表来存储图
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        //构建图
        for(int[] tmp : prerequisites){
            inDegree[tmp[0]]++;
            graph.get(tmp[1]).add(tmp[0]);
        }
        //准备进行狂赌遍历
        Queue <Integer> queue = new LinkedList <Integer>();
        for(int i = 0; i < numCourses; i++){
            //根据拓扑排序的要求，首先筛选出入度为0的节点作为起始节点
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        //进行广度优先搜索
        while(!queue.isEmpty()){
            int num = queue.poll();
            //加入结果集
            res.add(num);
            //找到所有和当前节点相邻的图节点
            for(int index : graph.get(num)){
                //由于刚刚节点被删除了，所以所有和它相邻的节点的入度都要减去1
                if(--inDegree[index] == 0){
                    //将更新后入度为0的节点入队
                    queue.offer(index);
                }
            }
        }
        int[] response = new int[res.size()];
        if(res.size() == numCourses){
            for(int i = 0; i < res.size(); i++){
                response[i] = res.get(i);
            }
            return response;
        }else{
            return new int[]{};
        }

    }
}

package Chapter14_深度搜索和广度搜索.Q207_课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 23:29
 **/

public class Solution {
    /**
     * 做拓扑排序，每添加一个节点，就将numCourses减去1，最后遍历完成时，比较numCourses是否等于0
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List <Integer>> list = new ArrayList <>();
        //保存节点入度的数组
        int[] inDegree = new int[numCourses];
        for(int i =0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        //邻接表保存图
        for(int[] tmp : prerequisites){
            inDegree[tmp[0]]++;
            list.get(tmp[1]).add(tmp[0]);
        }
        Queue <Integer> queue = new LinkedList <Integer>();
        //将入度为0的节点入队
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        //用队列对有向图进行广度遍历
        while(!queue.isEmpty()){
            int num = queue.poll();
            //每添加一个节点则numCourses减去1
            numCourses--;
            for(int index : list.get(num)){
                if(--inDegree[index] == 0){
                    queue.offer(index);
                }
            }
        }
        //当numCourses为0，表示图中无环，反之则图中存在环
        return numCourses == 0;
    }
}

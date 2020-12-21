package Chapter14_深度搜索和广度搜索.Q841_钥匙和房间;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:36
 **/

public class Solution {
    public boolean canVisitAllRooms(List<List <Integer>> rooms) {
        Queue <Integer> queue = new LinkedList <Integer>();
        //存储访问的房间数目
        int visit = 0;
        //标记房间是否访问过
        boolean[] visited = new boolean[rooms.size()];
        //初始有零号房间的钥匙
        queue.offer(0);
        while(!queue.isEmpty()){
            int key = queue.poll();
            //判断房间未进去过
            if(!visited[key]){
                //更新进去的房间数目和房间标记
                visited[key] = true;
                visit++;
                //将房间中的所有未进入的房间钥匙入队
                for(int i : rooms.get(key)){
                    if(!visited[i]){
                        queue.offer(i);
                    }
                }
            }
        }
        //如果所有房间都已经进去过那么返回true
        return visit == rooms.size();
    }
}

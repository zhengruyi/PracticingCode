package Chapter14_深度搜索和广度搜索.Q582_杀死进程;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:51
 **/

public class Solution {
    public List <Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap <Integer, LinkedList <Integer>> map = new HashMap<>();
        //首先根据父亲id的关系，将同一父进程的进程放入同一个链表中
        for(int i = 0; i < ppid.size(); i++){
            LinkedList<Integer> list = map.getOrDefault(ppid.get(i),new LinkedList<>());
            list.add(pid.get(i));
            map.put(ppid.get(i),list);
        }
        List<Integer> res = new ArrayList <>();
        Queue <Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()){
            int id = queue.poll();
            //记录要杀死的进程id
            res.add(id);
            //去除要杀死的父进程的所有进程，然后子进程入队
            if(map.containsKey(id)){
                for(int i : map.get(id)){
                    queue.offer(i);
                }
            }
        }
        return res;
    }
}

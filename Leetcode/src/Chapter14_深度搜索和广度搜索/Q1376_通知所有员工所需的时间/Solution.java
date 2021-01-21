package Chapter14_深度搜索和广度搜索.Q1376_通知所有员工所需的时间;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:41
 **/

public class Solution {
    /**
     * 本题就是先用哈希表构建树，然后用深度遍历遍历整个树，填满真个数组
     * 数组的最大值就是需要花费的时间来确保通知到每个人
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] res = new int[informTime.length];
        Map <Integer, List <Integer>> parent = new HashMap <>();
        //通过哈希表来构建多叉树，key为父节点编号,value是所有子节点的编号
        for(int i = 0; i < manager.length; i++){
            if(parent.containsKey(manager[i])){
                parent.get(manager[i]).add(i);
            }else{
                List<Integer> list = new ArrayList <>();
                list.add(i);
                parent.put(manager[i],list);
            }
        }
        //深度遍历来计算每个节点被通知到需要花费的时间
        dfs(headID,informTime,res,parent);
        return Arrays.stream(res).max().getAsInt();
    }
    public void dfs(int headID,int[] informTime,int[] res,Map<Integer,List<Integer>> parent){
        if(!parent.containsKey(headID)){
            return;
        }
        for(int index : parent.get(headID)){
            //通知子节点的时间等于到父节点花费的时间然后加上从父节点到子节点的时间
            res[index] = res[headID] + informTime[headID];
            dfs(index,informTime,res,parent);
        }
    }
}

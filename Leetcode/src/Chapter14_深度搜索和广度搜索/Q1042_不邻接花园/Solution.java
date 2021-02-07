package Chapter14_深度搜索和广度搜索.Q1042_不邻接花园;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/02/2021 22:27
 **/

public class Solution {
    /**
     * 本质就是广度遍历,去除掉不能种植的花的种类
     * @param n
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        HashMap<Integer, List <Integer>> map = new HashMap <>();
        //生成邻接图
        for(int i = 0; i < n; i++){
            map.put(i+1,new ArrayList());
        }
        //构造无向图
        for(int[] path : paths){
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        for(int i = 0; i < n; i++){
            //访问所有相邻的节点
            boolean[] used = new boolean[5];
            //如果相邻的花园已经种上了花,那么就标记不能种植的花的种类
            for(int neighbor : map.get(i+1)){
                used[res[neighbor-1]] = true;
            }
            //选择要栽种到当前花园的花的种类
            for(int j = 1; j <= 4; j++){
                if(!used[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}

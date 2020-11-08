package Chapter10_动态规划.Q403_青蛙过河;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 21:47
 **/

public class Solution {
    public boolean canCross(int[] stones) {
        //map 保存的是当前的是石子位置 -> 能调到当前位置需要跳的步数
        Map <Integer, Set <Integer>> map = new HashMap <>(stones.length);
        for(int i =0; i < stones.length; i++){
            map.put(stones[i],new HashSet <Integer>());
        }
        //初始状态
        map.get(0).add(0);
        for(int i = 0; i<stones.length; i++){
            for(int j : map.get(stones[i])){
                //取出集合的一个元素，代表从上一个节点跳到当前节点需要的步数
                //根据规则，下次可以跳elem,elem-1,elem+1,所以遍历这三种状态
                for(int k = j-1; k<= j+1; k++){
                    //为了避免一边遍历，一边修改造成ConcurrentModificationException，
                    //所以要去掉 k== 0这种情况
                    if(k > 0 && map.containsKey(stones[i]+k)){
                        map.get(stones[i]+k).add(k);
                    }
                }
            }
        }
        return map.get(stones[stones.length -1]).size() > 0;
    }
}

package Chapter0_其他.Q554_砖墙;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 15:25
 **/

public class Solution {
    public int leastBricks(List<List <Integer>> wall) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        for(int i =0; i < wall.size(); i++){
            List<Integer> list = wall.get(i);
            int sum = 0;
            //统计从左到右出现的宽度，每个数字都代表从开头到当前位置的宽度和
            //代表这里有空隙
            for(int j = 0; j < list.size() - 1; j++){
                sum += list.get(j);
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        //墙的总厚度是墙的层数，减去map里面保存的空隙数，等于最终要穿过的墙的数目
        int res = wall.size();
        for(Integer i : map.keySet()){
            res = Math.min(res, wall.size() - map.get(i));
        }
        return res;
    }
}

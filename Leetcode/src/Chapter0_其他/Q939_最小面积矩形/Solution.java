package Chapter0_其他.Q939_最小面积矩形;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/02/2021 23:41
 **/

public class Solution {
    public int minAreaRect(int[][] points) {
        //根据横坐标将统一列的坐标合并到一起
        HashMap<Integer, Set <Integer>> map = new HashMap <>();
        for(int[] point : points){
            if(map.containsKey(point[0])){
                map.get(point[0]).add(point[1]);
            }else{
                HashSet <Integer> set = new HashSet();
                set.add(point[1]);
                map.put(point[0],set);
            }
        }
        int len = points.length;
        int res = Integer.MAX_VALUE;
        //两个坐标遍历
        for(int i = 0; i < len; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < len; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 || y2 == y1){
                    continue;
                }
                //说明在x1上有两个坐标(x1,y1),(x1,y2),(x2,y1)(x2,y2)四个坐标，否成了矩形
                //更新最小的矩形面积
                if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                    res = Math.min(res, Math.abs(x1-x2) * Math.abs(y1 - y2));
                }
            }
        }
        //检查矩形是否存在
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

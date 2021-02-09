package Chapter0_其他.Q447_回旋镖的数量;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/02/2021 21:11
 **/

public class Solution {
    /**
     * 选取一个点为中心节点,然后计算其他点到这个点的距离,并用哈希表进行统计
     * 然后根据距离的出现次数计算回旋镖的数量，因为计算时考虑顺序,所以多余距离为i，出现次数为j
     * 那么总的回旋镖数量就是j*(j-1)
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        if(points.length < 3){
            return 0;
        }
        int len = points.length;
        int res = 0;
        for(int i = 0; i < len; i++){
            Map <Integer,Integer> map = new HashMap <>();
            for(int j = 0; j < len; j++){
                if(j == i){
                    continue;
                }
                int distance = distance(points[i],points[j]);
                map.put(distance,map.getOrDefault(distance,0) + 1);
            }
            for(int key : map.keySet()){
                int times = map.get(key);
                //从n中挑选两个,最后因为考虑顺序,再乘以2,所以总的结果就是 j*(j-1)
                res += times *(times - 1);
            }
        }
        return res;
    }
    public int distance(int[] x1, int[] y1){
        return (x1[0] - y1[0]) * (x1[0] - y1[0]) + (x1[1] - y1[1]) * (x1[1] - y1[1]);
    }
}

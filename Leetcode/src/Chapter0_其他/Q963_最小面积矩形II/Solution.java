package Chapter0_其他.Q963_最小面积矩形II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/03/2021 23:31
 **/

public class Solution {
    /**
     * 如果两组坐标构成的直线长度相等且两组坐标的中心点重合在一起,那么这四个点可以构成矩形
     * 可以计算他们的面积
     * @param points
     * @return
     */
    public double minAreaFreeRect(int[][] points) {
        HashMap<String, List <int[]>> map = new HashMap();
        StringBuilder builder = new StringBuilder();
        int len = points.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int dist = getDistance(points[i],points[j]);
                double[] center = getCenter(points[i],points[j]);
                String key = dist +":" + center[0] + ":" + center[1];
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList());
                }
                map.get(key).add(new int[]{i,j});
            }
        }
        double res = Double.MAX_VALUE;
        for(String key : map.keySet()){
            if(map.get(key).size() == 1){
                continue;
            }
            List<int[]> datas = map.get(key);
            for(int i = 0; i < datas.size(); i++){
                for(int j = i + 1; j < datas.size(); j++){
                    int[] index1 = datas.get(i);
                    int[] index2 = datas.get(j);
                    double area = Math.sqrt(getDistance(points[index1[0]],points[index2[0]])) * Math.sqrt(getDistance(points[index1[1]],points[index2[0]]));
                    res = Math.min(res,area);
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }
    public int getDistance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
    public double[] getCenter(int[] p1, int[] p2){
        double[] res = new double[2];
        res[0] = (p1[0] + p2[0]) /2.0;
        res[1] = (p1[1] + p2[1]) /2.0;
        return res;
    }
}

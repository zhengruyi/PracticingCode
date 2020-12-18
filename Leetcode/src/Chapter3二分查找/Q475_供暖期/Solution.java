package Chapter3二分查找.Q475_供暖期;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:43
 **/

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        //对取暖器进行排序
        Arrays.sort(heaters);
        //二分搜索找到最近的一个取暖器
        for(int house : houses){
            int left = 0;
            int right = heaters.length;
            while(left < right){
                int mid = left + (right - left)/2;
                if(heaters[mid] < house){
                    left = mid +1;
                }else{
                    right = mid;
                }
            }
            //计算相邻的两个取暖器到该房子的距离，去其中最小的那个，对于radius取全局最大值
            int dist1 = (right == 0) ? Integer.MAX_VALUE : Math.abs(house - heaters[right-1]);
            int dist2 = (right == heaters.length) ? Integer.MAX_VALUE : Math.abs(house - heaters[right]);
            radius = Math.max(radius,Math.min(dist1,dist2));
        }
        return radius;
    }
}

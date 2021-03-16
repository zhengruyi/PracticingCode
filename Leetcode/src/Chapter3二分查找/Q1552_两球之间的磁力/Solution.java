package Chapter3二分查找.Q1552_两球之间的磁力;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/03/2021 21:40
 **/

public class Solution {
    /**
     * 首先设定一个两球之间的距离的最大值,那么按照两球之间的距离不大于的规则，放置磁球,计算球的数目
     * 如果需要球的数目过多就增加两球之间的距离,如果过少则可可以适当缩小两球之间的距离来增加放置球的数目
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
        //区间的最大值
        int hi = (position[position.length - 1] - position[0] )/(m-1);
        int res = 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            //能否在球之间的距离不低于mid时放入m个球,返回true表示需要更多的球,那么表示距离可以更大
            if(check(position,mid,m)){
                res = mid;
                lo = mid + 1;
                //球的数量过少,需要减小距离
            }else{
                hi = mid - 1;
            }
        }
        return res;
    }

    /**
     * 计算两球之间的距离不超过distance时需要球的数量是否超过m,超过返回true,否则返回false
     * @param position
     * @param distance
     * @param m
     * @return
     */
    public boolean check(int[] position, int distance, int m){
        int i = 0;
        int count = 1;
        for(int j = 1; j < position.length; j++){
            if(position[j] - position[i] >= distance){
                i = j;
                count++;
                if(count >= m){
                    return true;
                }
            }
        }
        return false;
    }
}

package Chapter4_双指针技巧.Q849_到最近的人的距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/02/2021 20:17
 **/

public class Solution {
    public int maxDistToClosest(int[] seats) {
        //在当前位置左边坐着的第一个人的坐标
        int left = -1;
        //在当前位置的右边坐着的第一个人的坐标
        int right = 0;
        int len = seats.length;
        //当前位置离的最近的一个人的距离的最大值
        int max = 0;
        for(int i = 0; i < len; i++){
            //更新左边第一个人的坐标
            if(seats[i] == 1){
                left = i;
            }else{
                //找到右边第一个人的坐标,当right < i时触发更新
                while(right < len && (seats[right] == 0 || right < i)){
                    right++;
                }
                //更新左右两边离的最近的一个人的距离的最大值
                int distLeft = left == -1 ? len : i - left;
                int distRight = right == len ? len : right - i;
                //更新全局答案
                max = Math.max(max,Math.min(distLeft,distRight));
            }
        }
        return max;
    }
}

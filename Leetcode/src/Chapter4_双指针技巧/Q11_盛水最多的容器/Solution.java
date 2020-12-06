package Chapter4_双指针技巧.Q11_盛水最多的容器;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 15:44
 **/

public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while(start < end){
            //成水多少取决于最短的木板，所以取两端的最小值
            int min = Math.min(height[start],height[end]);
            //由于长版移动一定会造成盛水的容量减少，而短板移动可能会是容量上升，所以
            //每次移动短板
            res = Math.max(res,min * (end - start));
            if(min == height[start]){
                start++;
            }else{
                end --;
            }
        }
        return res;
    }
}

package Chapter0_其他.Q42_接雨水;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/10/2020 17:15
 **/

public class Solution {
    /**
     * 计算方法是左右柱子中较矮的那个和当前的高度差就是接到的雨水量
     * @param height
     * @return
     */
    public int trap(int[] height){
        if(height.length == 0){
            return 0;
        }
        int len = height.length;
        //左边的最高的柱子高度
        int l_max = height[0];
        //右侧的柱子最高的高度
        int r_max = height[len-1];
        int left = 0;
        int right = len-1;
        int res = 0;
        while(left <= right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            //当l_max较小时，可能r_max并不是left右边最高的柱子，当这里不影响计算
            if(l_max < r_max){
                res += l_max - height[left];
                left++;
            }else{
                res+= r_max - height[right];
                right--;
            }
        }
        return res;
    }
}

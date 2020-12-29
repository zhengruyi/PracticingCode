package Chapter0_其他.Q163_缺失的区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:01
 **/

public class Solution {
    public List <String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList <>();
        int low = 0;
        int high = 0;
        /**
         * 将lower和upper 合并到数组中，但是要注意这里要用到lower-1和higher+1
         * 因为lower和higher是包含在内的，为了简化，所以合并时用的是lower-1和higher+1
         * 这样就可以统一边界条件了
         */
        for(int i = -1; i < nums.length; i++){
            low = i == -1 ? lower - 1 : nums[i];
            high = i < nums.length - 1  ? nums[i+1] : upper + 1;
            if(high == low + 2){
                res.add(String.valueOf(low+1));
            }else if(high - low > 2){
                res.add(String.format("%d->%d",low+1, high-1));
            }
        }
        return res;
    }
}

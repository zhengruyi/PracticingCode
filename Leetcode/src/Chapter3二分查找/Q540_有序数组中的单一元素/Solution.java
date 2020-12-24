package Chapter3二分查找.Q540_有序数组中的单一元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:50
 **/

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length -1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            //计算从mid_1..end的元素个数
            boolean isEven = (hi - mid) % 2 != 0;
            //根据中间值的相同的元素位置和右区间包含的元素数目奇偶性来推断元素所在的区间
            if(nums[mid + 1] == nums[mid]){
                //右区间元素数目为奇数，且mid +1的值等于mid,那么右区间剩下的数目为偶数，则这个数字必定在左区间
                if(isEven){
                    hi = mid - 1;
                }else{
                    //右区间元素数目为偶数，且mid +1的值等于mid,那么右区间剩下的数目为奇数，则这个数字必定在右区间
                    lo = mid + 2;
                }
            }else if(nums[mid] == nums[mid-1]){
                //右区间元素数目为偶数，且mid - 1的值等于mid,那么左区间剩下的数目为奇数，则这个数字必定在左区间
                if(!isEven){
                    hi = mid - 2;
                }else{
                    //右区间元素数目为奇数，且mid - 1的值等于mid,那么右区间剩下的数目为奇数数，则这个数字必定在右区间
                    lo  = mid + 1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[lo];
    }
}

package Chapter0_其他.Q448_找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengruyi
 */
public class Solution {
    public List <Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList <Integer>();
        for(int i =0; i < nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            //如果nums[i] < 0, 则对应索引有数字对应，所以直接跳过,因为有数字重复，防止出翔两次导致的误判，每次都要判断
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        //所有索引上的数字大于0的，代表无数字对应
        for(int i =0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}
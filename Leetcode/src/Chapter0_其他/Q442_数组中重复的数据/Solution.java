package Chapter0_其他.Q442_数组中重复的数据;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/12/2020 23:48
 **/

public class Solution {
    public List <Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList <Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        //由于初始所偶遇元素的范围为1 <= a[i] <= n
        //所以第一次会将元素变成相反数，第二次再碰到时就可以断定这个元素出现了两次
        //同样的方法也可以判断奇数次出现的元素
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}

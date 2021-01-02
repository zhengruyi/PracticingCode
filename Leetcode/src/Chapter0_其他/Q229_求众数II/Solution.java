package Chapter0_其他.Q229_求众数II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 18:30
 **/

public class Solution {
    public List <Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList <>();
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        //这里要去数字的出现次数大于n/3，则可知最多两个数字满足要求
        int num1 = nums[0];
        int num2 = nums[0];
        //统计当前认定的数字的出现次数
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            //和往常一样，如果数字相同就加1,不用就减1
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
                //统计次数降到0以下时就更新称当前数字
            }else if(count1 == 0){
                num1 = nums[i];
                count1=1;
            }else if(count2 == 0){
                num2 = nums[i];
                count2 = 1;
            }else{
                count2--;
                count1--;
            }
        }
        count1 = 0;
        count2 = 0;
        //球面求出的num1和num2只是两个可能的数字，后面需要具体验证以下是否出现次数满足要求
        for(int i = 0; i < nums.length; i++){
            if(num1 == nums[i]){
                count1++;
            }else if(num2 == nums[i]){
                count2++;
            }
        }
        if(count1 > nums.length /3){
            res.add(num1);
        }
        if(count2 > nums.length /3){
            res.add(num2);
        }
        return res;
    }
}

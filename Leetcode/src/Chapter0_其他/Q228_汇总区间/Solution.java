package Chapter0_其他.Q228_汇总区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:42
 **/

public class Solution {
    public List <String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList <>();
        if(nums.length == 0){
            return res;
        }
        int left = nums[0];
        int right = left;
        for(int i = 1; i < nums.length; i++){
            //和前一段连接上，只更新right坐标
            if(nums[i] == right + 1){
                right = nums[i];
                continue;
            }
            //如果只有一个数则直接装入
            if(right == left){
                res.add(String.valueOf(right));
            }else{
                //区间，则表示成区间形式
                res.add(String.format("%s->%s",left,right));
            }
            left = nums[i];
            right = left;
        }
        //由于上面的循环只会在遇到不连续区间时工作，所以这里要处理一下末尾情况
        if(right == left){
            res.add(String.valueOf(right));
        }else{
            res.add(String.format("%s->%s",left,right));
        }
        return res;
    }
}

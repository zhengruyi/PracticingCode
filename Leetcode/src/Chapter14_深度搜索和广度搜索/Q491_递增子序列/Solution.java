package Chapter14_深度搜索和广度搜索.Q491_递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 00:13
 **/

public class Solution {
    List<List <Integer>> res = new ArrayList <>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        dfs(nums,Integer.MIN_VALUE,0);
        return res;
    }
    public void dfs(int[] nums,int last, int curr){
        if(curr == nums.length){
            if(tmp.size() >= 2){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if(nums[curr] >= last){
            tmp.add(nums[curr]);
            dfs(nums,nums[curr],curr+1);
            tmp.remove(tmp.size()-1);
        }
        //这里采用当前数字不能和上次数字相同来保证所有答案都不重复
        if(nums[curr] != last){
            dfs(nums,last,curr+1);
        }
    }
}

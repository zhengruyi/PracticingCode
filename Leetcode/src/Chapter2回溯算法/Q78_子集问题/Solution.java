package Chapter2回溯算法.Q78_子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/10/2020 16:51
 **/

public class Solution {
    public List<List <Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> track = new ArrayList<Integer>();
        backTrack(res,track,nums,0);
        return  res;
    }
    public void backTrack(List<List<Integer>> res, List<Integer> track, int[] nums, int start){
        res.add(new ArrayList(track));
        for(int i = start; i < nums.length; i++){
            track.add(nums[i]);
            backTrack(res,track,nums,i+1);
            track.remove(track.size()-1);
        }
    }
}

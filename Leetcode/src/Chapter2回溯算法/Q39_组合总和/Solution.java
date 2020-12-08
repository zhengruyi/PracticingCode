package Chapter2回溯算法.Q39_组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/12/2020 23:54
 **/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List <Integer>>();
        List<Integer> path = new ArrayList <Integer>();
        recursive(candidates,target,res,0,path);
        return res;
    }
    public void recursive(int[] candidates,int target,List<List<Integer>> res, int sum,List<Integer> path){
        if(sum == target){
            res.add(new ArrayList<>(path));
        }
        if(sum > target){
            return;
        }
        for(int i = 0; i < candidates.length;i++){
            int last = path.size() -1;
            //通过递增来避免重复数据
            if(last == -1 || candidates[i] >= path.get(last)){
                path.add(candidates[i]);
                sum+=candidates[i];
                recursive(candidates,target,res,sum,path);
                sum-=candidates[i];
                path.remove(path.size() -1);
            }
        }
    }
}

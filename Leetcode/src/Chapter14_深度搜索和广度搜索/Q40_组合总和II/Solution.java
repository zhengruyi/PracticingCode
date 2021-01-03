package Chapter14_深度搜索和广度搜索.Q40_组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/01/2021 22:56
 **/

public class Solution {
    List<List <Integer>> res = new ArrayList <>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //因为排除重复的要求，所以要先排序
        Arrays.sort(candidates);
        dfs(candidates,0,candidates.length,target);
        return res;
    }
    public void dfs(int[] candidates, int begin, int len, int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //本来一直考虑就是怎么处理递归边长的情况，这里借用begin来实现
        //这种情况,另外排除重复结果的情况和以前相同, nums[i]==nums[i-1]且i-1未访问时跳过
        for(int i = begin; i < len; i++){
            if(target - candidates[i] < 0){
                break;
            }
            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,i+1,len, target - candidates[i]);
            path.remove(path.size() -1);
        }
    }
}

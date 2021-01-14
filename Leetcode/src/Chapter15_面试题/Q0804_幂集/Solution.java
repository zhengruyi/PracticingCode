package Chapter15_面试题.Q0804_幂集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:33
 **/

public class Solution {
    List<List <Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList <>();
        dfs(nums,new ArrayList<>(),0);
        return res;
    }

    /**
     * 回溯算法来搜索所有的子集
     * @param nums
     * @param path
     * @param start
     */
    public void dfs(int[] nums, List<Integer> path, int start){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums,path,i+1);
            path.remove(path.size() -1);
        }
    }
}

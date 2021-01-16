package Chapter14_深度搜索和广度搜索.Q90_子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:31
 **/

public class Solution {
    List<List<Integer>> res;
    public List<List <Integer>> subsetsWithDup(int[] nums) {
        //只要问题就是怎么避免重复解,解决办法就是来颁发排序后结果visited数组来处理
        Arrays.sort(nums);
        res = new ArrayList <>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int[] nums, boolean[] visited,List<Integer> path, int start){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            //如果当前元素被访问且前一个相同的元素未访问就跳过因为当前解肯定重复
            if(i > 0 && nums[i-1] == nums[i] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums,visited,path,i+1);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

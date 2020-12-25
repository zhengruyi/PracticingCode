package Chapter14_深度搜索和广度搜索.Q47_全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 22:52
 **/

public class Solution {
    List<List <Integer>> res = new ArrayList <>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //为了提出重复元素，需要对原数组先排序
        Arrays.sort(nums);
        //记录元素是否被访问过
        used = new boolean[nums.length];
        //保存访问后的元素
        List<Integer> tmp = new ArrayList<>();
        dfs(nums,tmp);
        return res;
    }
    public void dfs(int[] nums,List<Integer> tmp){
        //到达数组末尾，保存最后的结果
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for(int i = 0 ; i < nums.length; i++){
            //由于每次递归都会访问全部元素，所以需要记录当前元素是否访问过
            //排除重复的条件是前边元素的当前元素相同且未访问,可以将所偶遇过程列出来来确定
            //提出重复结果的条件
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            dfs(nums,tmp);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}

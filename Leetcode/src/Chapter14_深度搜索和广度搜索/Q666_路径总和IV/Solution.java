package Chapter14_深度搜索和广度搜索.Q666_路径总和IV;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/02/2021 22:24
 **/

public class Solution {
    HashMap <Integer,Integer> map;
    int res = 0;
    public int pathSum(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        map = new HashMap<>();
        //将数组拆分为坐标和延迟的时间
        for(int num : nums){
            map.put(num / 10, num % 10);
        }
        //从根节点开始搜索
        dfs(nums[0]/10, 0);
        return res;
    }
    public void dfs(int root, int sum){
        if(!map.containsKey(root)){
            return;
        }
        //计算当前节点的深度和位置
        int depth = root / 10;
        int pos = root % 10;
        //计算左节点和右节点对应坐标
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        //累加和
        sum += map.get(root);
        //如果当前节点是子节点，那么加上子路径和
        if(!map.containsKey(left) && !map.containsKey(right)){
            res += sum;
        }else{
            //递归遍历左右子树
            dfs(left,sum);
            dfs(right,sum);
        }
    }
}

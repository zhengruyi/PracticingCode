package Chapter0_其他.Q508_出现次数最多的子树元素和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/02/2021 21:23
 **/

public class Solution {
    int maxCount = 0;
    HashMap <Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap();
        dfs(root);
        List <Integer> res = new ArrayList();
        for(int key : map.keySet()){
            if(maxCount == map.get(key)){
                res.add(key);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //计算以当前节点为根节点的所有元素和
        int sum = root.val + left + right;
        //更新数字出现频率
        int times = map.getOrDefault(sum,0);
        //更新最大的出现频率
        if(maxCount < times + 1){
            maxCount = times + 1;
        }
        map.put(sum,times + 1);
        return sum;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
package Chapter14_深度搜索和广度搜索.Q652_寻找重复的子树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:45
 **/

public class Solution {
    HashMap <String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList <>();
    public List <TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return res;
    }

    /**
     * 采用序列化的方式,来查看是否有重复子树
     * @param node
     * @return
     */
    public String collect(TreeNode node){
        if(node == null){
            return "#";
        }
        //采用StringBuilder的拼接方式比普通+号拼接要快很多
        StringBuilder builder = new StringBuilder();
        //格式化序列
        builder.append(node.val).append(",").append(collect(node.left)).append(",").append(collect(node.right));
        String ser = builder.toString();
        //更新出现频率
        map.put(ser,map.getOrDefault(ser,0) + 1);
        //这里不采用包含的判断的方式是因为防止出现一个重复子树多次出现，而在结果集中出现多次的问题
        if(map.get(ser) == 2){
            res.add(node);
        }
        return ser;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

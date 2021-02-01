package Chapter14_深度搜索和广度搜索.Q314_二叉树的垂序遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/02/2021 23:06
 **/

public class Solution {
    List <Location> locations = new ArrayList <>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //深度遍历将所有节点相对于根节点的偏移量获取到
        //然后根据坐标进行排序
        dfs(root,0,0);
        Collections.sort(locations);
        //生层的结果时通过x从小到大遍历的方式来获取的
        int prev = locations.get(0).x;
        res.add(new ArrayList());
        for(Location location : locations){
            //说明location不在当前列中,那么添加一个新的列表
            if(location.x != prev){
                prev = location.x;
                res.add(new ArrayList());
            }
            res.get(res.size() - 1).add(location.val);
        }
        return res;
    }
    public void dfs(TreeNode root,int x, int y){
        if(root == null){
            return;
        }
        locations.add(new Location(x,y,root.val));
        dfs(root.left,x-1,y+1);
        dfs(root.right,x+1,y+1);
    }
}
class Location implements Comparable<Location>{
    public int x;
    public int y;
    public int val;
    public Location(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    @Override
    public int compareTo(Location l){
        if(this.x != l.x){
            return this.x - l.x;
        }else {
            return this.y - l.y;
        }
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
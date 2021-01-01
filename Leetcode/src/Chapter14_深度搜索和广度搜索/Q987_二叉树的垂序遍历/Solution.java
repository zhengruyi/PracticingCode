package Chapter14_深度搜索和广度搜索.Q987_二叉树的垂序遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/01/2021 22:28
 **/

public class Solution {
    List <Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList <>();
        //深度遍历来保存值和对应的坐标
        dfs(root,0,0);
        //Collections.sort()排序要求被调用的类必须实现Comparable接口
        Collections.sort(locations);
        List<List<Integer>> res = new ArrayList<>();
        //由于每次将同一列的结果放在一起
        int prev = locations.get(0).x;
        res.add(new ArrayList<>());
        for(Location location : locations){
            if(prev != location.x){
                prev = location.x;
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(location.val);
        }
        return res;
    }
    public void dfs(TreeNode root, int x, int y){
        if(root == null){
            return ;
        }
        locations.add(new Location(x,y,root.val));
        dfs(root.left,x-1,y+1);
        dfs(root.right,x+1,y+1);
    }
}

/**
 * 新建类用来保存值和值对应的坐标
 */
class Location implements Comparable<Location>{
    public int x;
    public int y;
    public int val;
    public Location(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }

    /**
     * 排序规则，从左往右遍历,优先比较x判断是否在一列,然后比较y来判断从上到下排列
     * 最后比较值从小到达
     * @param l
     * @return
     */
    @Override
    public int compareTo(Location l){
        if(this.x != l.x){
            return Integer.compare(this.x,l.x);
        }else if(this.y != l.y){
            return Integer.compare(this.y,l.y);
        }else{
            return Integer.compare(this.val,l.val);
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

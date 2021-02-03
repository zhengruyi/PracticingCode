package Chapter14_深度搜索和广度搜索.Q1367_二叉树中的列表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/02/2021 23:09
 **/

public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        //head == null 则无论 root是否等于null都返回true
        if(head == null){
            return true;
        }else if( root == null){
            return false;
        }
        //只要当前节点或者左子节点或者右子节点存在目标链表时，返回true
        return dfs(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public boolean dfs(ListNode head, TreeNode root){
        if(head == null){
            return true;
        }else if(root == null){
            return false;
            //当前值树节点值和链表节点值相等，那么久在左右子树中尝试搜索链表的下一个节点
        }else if(head.val == root.val){
            return dfs(head.next,root.left) || dfs(head.next,root.right);
        }else{
            //不然就返回false
            return false;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
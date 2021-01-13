import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        int[] preOrder = {8,5,1,7,10,12};
        bstFromPreorder(preOrder);
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int mid = findIndex(start,end,preorder);
        root.left = construct(preorder,start+1,mid);
        root.right = construct(preorder,mid+1,end);
        return root;
    }
    public int findIndex(int start, int end, int[]preorder){
        int i = start;
        while(i+1 <= end && preorder[i+1] > preorder[start]){
            i++;
        }
        return i;
    }

}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
package Q33_二叉搜索树的后序遍历序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:11
 **/

public class Solution {
    /**
     * 左子树的所有值小于各节点的值，右子树的所有值大于根节点
     * 且左右子树也是二叉搜索树
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return checkBST(postorder,0,postorder.length-1);
    }
    public boolean checkBST(int[] postorder, int i, int j){
        //一个根节点或者空节点都算二叉搜索树
        if(i >= j){
            return true;
        }
        //从起始点搜索，所有小于根节点的值都在左子树
        int p = i;
        while(postorder[p] < postorder[j]){
            p++;
        }
        //记录下左右子树的交接点
        int mid = p;
        //遍历右子树，保证所有右子树的值都大于根节点
        while(postorder[p] > postorder[j]){
            p++;
        }
        //确认当前子树符合要求，递归判断左右子树是否也是二叉搜索树
        return p == j && checkBST(postorder,i,mid-1) && checkBST(postorder,mid,j-1);
    }
}

package Q26_树的子结构;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:27
 **/

public class Solution {
    /**
     * 以当前节点为根节点或者左右子节点为根节点，只要三种情况满足之一
     * 就可以说B是A的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null && B != null) {
            return false;
        } else if (A != null && B == null) {
            return false;
        } else {
            return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    /**
     * 是子结构的要求是根节点值相同且左右子节点值也各自相同
     * @param A
     * @param B
     * @return
     */
    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
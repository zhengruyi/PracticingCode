package Chapter11_单调栈.Q255_验证前序遍历序列二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/02/2021 19:07
 **/

public class Solution {
    /**
     * 采用原数组，所以空间复杂度是O(1)
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        int top = -1;
        int min = Integer.MIN_VALUE;
        //因为要求右子树的最小值还是要大于左子树的最大值所以要保存左子树的最大值
        //单调栈从栈底到栈顶是单调递减的,所以最后的栈顶元素就是左子树的最大值
        for(int num: preorder){
            //如果右子树的有值小于左子树的最大值，那么就不是二叉搜索树
            if(num < min){
                return false;
            }
            //连续弹栈，直到直到找到根节点的值
            while(top != -1 && num > preorder[top]){
                min = preorder[top];
                --top;
            }
            //压栈
            preorder[++top] = num;
        }
        return true;
    }
}

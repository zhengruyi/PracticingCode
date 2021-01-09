package Chapter14_深度搜索和广度搜索.Q889_根据前序和后序遍历构造二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:42
 **/

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre,post,0,0,pre.length);
    }

    /**
     * 由于没有中序遍历序列，所以无法确定唯一的二叉树，这里采用在找到左子树的根然后在后续遍历中
     * 找到对应节点来分割序列,采用数组长度来控制返回的是null还是一个节点
     * @param pre
     * @param post
     * @param first
     * @param last
     * @param length
     * @return
     */
    public TreeNode construct(int[] pre, int[] post, int first, int last, int length){
        if(length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[first]);
        if(length == 1){
            return root;
        }
        int len = 1;
        //查找根节点在后续遍历中的位置
        for(;len < length; len++){
            if(post[last + len - 1] == pre[first+1]){
                break;
            }
        }
        //对于左子树来说，前序的开始节点加1，后续的初始节点不变，序列长度为len
        root.left = construct(pre,post,first+1,last,len);
        //对于右子树来说,前序为first+len+1,因为first已经被用掉，后续就是last+len，常数为总长度减掉用掉的1在减去左子树长度等于右子树的长度
        root.right = construct(pre,post,first+len+1,last+len,length - 1 - len);
        return root;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
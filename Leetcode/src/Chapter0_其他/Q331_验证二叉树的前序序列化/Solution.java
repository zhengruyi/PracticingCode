package Chapter0_其他.Q331_验证二叉树的前序序列化;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/03/2021 23:34
 **/

public class Solution {
    /**
     * 树的所有节点的入度和出度相等,所以直接统计一下入度和出度的和,如果为0就是一颗二叉树
     * 否则不是
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        //起始设置为1，因为起始是根节点,先减去入度，再加上出度
        //如果设置成0，那么就会再开始变成-1,所以返回false
        int diff = 1;
        for(int i = 0; i < strs.length; i++){
            //减去入度
            diff -= 1;
            if(diff < 0){
                return false;
            }
            //如果是非空节点,那么加上出度2
            if(!strs[i].equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}

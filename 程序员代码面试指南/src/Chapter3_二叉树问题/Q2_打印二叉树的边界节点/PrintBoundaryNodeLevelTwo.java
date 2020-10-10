package Chapter3_二叉树问题.Q2_打印二叉树的边界节点;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/05/2020 14:48
 **/

public class PrintBoundaryNodeLevelTwo {
    public static void print(Tree root){
        if(root == null){
            return;
        }
        int height = getHeight(root,0);
        Tree[][] edgeMap = new Tree[height][2];
        setEdgeMap(root, edgeMap);
        for (int i = 0; i < edgeMap.length; i++) {
            if(edgeMap[i][0] != null){
                System.out.print(" "+edgeMap[i][0].value);
            }
        }
        printLeafNotInMap(root,0,edgeMap);
        for (int i = edgeMap.length - 1; i > 0; i--) {
            if(edgeMap[i][1] != null){
                System.out.print(" "+edgeMap[i][1].value);
            }
        }
    }

    /**
     * 确定树的左右边界，并把每一层的边界点都放入数组中
     * @param root
     * @param map
     */
    public static void setEdgeMap(Tree root, Tree[][] map){
        if(root == null){
            return;
        }
        Tree temp = root;
        int i = 0;
        while (temp != null){
            map[i][0] = temp;
            i++;
            temp = temp.left != null ? temp.left : temp.right;
        }
        temp = root;
        i = 0;
        while (temp != null){
            map[i][1] = temp;
            i++;
            temp = temp.right != null ? temp.right : temp.left;
        }
    }
    public static void printLeafNotInMap(Tree root, int level, Tree[][] map){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && root != map[level][0] && root != map[level][1]){
            System.out.print(" "+root.value);
        }
        printLeafNotInMap(root.left,level+1,map);
        printLeafNotInMap(root.right,level+1,map);
    }
    public static  int getHeight(Tree root,int h){
        if(root == null){
            return h;
        }
        return Math.max(getHeight(root.left,h+1),getHeight(root.right,h+1));
    }
    public static void main(String[] args) {
        Tree t13 = new Tree(13);
        Tree t14 = new Tree(14);
        Tree t15 = new Tree(15);
        Tree t16 = new Tree(16);
        Tree t11 = new Tree(11,t13,t14);
        Tree t12 = new Tree(12,t15,t16);
        Tree t7 = new Tree(7);
        Tree t8 = new Tree(8,null,t11);
        Tree t9 = new Tree(9,t12,null);
        Tree t10 = new Tree(10);
        Tree t4 = new Tree(4,t7,t8);
        Tree t5 = new Tree(5,t9,t10);
        Tree t6 = new Tree(6);
        Tree t2 = new Tree(2,null,t4);
        Tree t3 = new Tree(3,t5,t6);
        Tree t1 = new Tree(1,t2,t3);
        print(t1);
    }
}

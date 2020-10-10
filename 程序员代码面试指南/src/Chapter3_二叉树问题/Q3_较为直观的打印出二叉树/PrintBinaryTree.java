package Chapter3_二叉树问题.Q3_较为直观的打印出二叉树;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/05/2020 15:06
 **/

public class PrintBinaryTree {
    /**
     * 标准元素长度是最长的int类型加上^*2+空格*2 = 17
     */
    final static int LENGTH = String.valueOf(Integer.MIN_VALUE).length() + 2 + 2;
    public static void printBinaryTree(Tree root){
        if(root == null){
            return;
        }
        printBinaryTree(root,0,Type.ROOT);
    }
    public static void printBinaryTree(Tree root, int level, Type location){
        if(root == null){
            return;
        }
        printBinaryTree(root.right, level +1, Type.RIGHT);
        print(root.value,location,level);
        printBinaryTree(root.left, level +1, Type.LEFT);

    }
    public static void print(int value, Type location, int level){
        String offsetSpaces = "                 ";
        StringBuilder prefixSpaces = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int len = String.valueOf(value).length();
        int offset = (LENGTH - (len + 2))/2;
        for (int i = 0; i < offset; i++) {
            prefixSpaces.append(" ");
        }
        String pre;
        if(location == Type.LEFT){
            pre = "^";
        }else if(location == Type.RIGHT){
            pre = "v";
        }else{
            pre = "H";
        }
        result.append(prefixSpaces.toString());
        result.append(pre);
        result.append(value);
        result.append(pre);
        result.append(prefixSpaces.toString());
        result.append(result.length() == LENGTH ? "" : " ");
        while (level-- != 0){
            System.out.print(offsetSpaces);
        }
        System.out.print(result.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        Tree t7 = new Tree(7);
        Tree t4 = new Tree(4,null,t7);
        Tree t5 = new Tree(5);
        Tree t6 = new Tree(6);
        Tree t2 = new Tree(2,t4,null);
        Tree t3 = new Tree(3,t5,t6);
        Tree t1 = new Tree(1,t2,t3);
        printBinaryTree(t1);
    }
}

/**
 * 表示当前在父节点的方位
 */
enum Type{
    //左子树
    LEFT,
    //右子树
    RIGHT,
    //根节点
    ROOT,
}
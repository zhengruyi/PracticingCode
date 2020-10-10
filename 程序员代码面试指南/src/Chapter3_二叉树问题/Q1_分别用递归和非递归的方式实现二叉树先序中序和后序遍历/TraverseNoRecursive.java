package Chapter3_二叉树问题.Q1_分别用递归和非递归的方式实现二叉树先序中序和后序遍历;

import Chapter3_二叉树问题.Tree;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 21:58
 **/

public class TraverseNoRecursive {
    public static void preTraverse(Tree root) {
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack <>();
        stack.push(root);
        while (!stack.isEmpty()){
            Tree temp = stack.pop();
            System.out.print(temp.value);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    /**
     * 会破坏原来的树结构，不推荐
     * @param root
     */
    public static void inTraverse(Tree root) {
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack <>();
        stack.push(root);
        while (!stack.isEmpty()){
            Tree temp = stack.pop();
            if(temp.left != null) {
                stack.push(temp);
                stack.push(temp.left);
                temp.left = null;
            }else {
                System.out.print(temp.value);
                if(temp.right != null){
                    stack.push(temp.right);
                }
            }
        }
    }

    /**
     * 不破坏树的结构，中序遍历较好的实现方式
     * @param root
     */
    public static void inTraverseBetter(Tree root) {
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack <>();
        Tree temp =root;
        while (!stack.isEmpty() || temp != null){
            //一直遍历到做左边的左节点
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                //说明当前节点没有左节点，则可以输出自己的值作为中节点的值
                temp = stack.pop();
                System.out.print(temp.value);
                temp = temp.right;
            }
        }
    }

    /**
     * 会破坏原来结构的后序遍历方式，不推荐
     * @param root
     */
    public static void postTraverse(Tree root) {
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack <>();
        stack.push(root);
        while (!stack.isEmpty()){
            Tree temp = stack.peek();
            if(temp.left != null || temp.right != null){
                if(temp.right != null){
                    stack.push(temp.right);
                    temp.right = null;
                }
                if(temp.left != null){
                    stack.push(temp.left);
                    temp.left = null;
                }
            }else{
                Tree t = stack.pop();
                System.out.print(t.value);
            }
        }
    }

    /**
     * 不破坏原来树结构的后序遍历方式，推荐
     * @param root
     */
    public static void postTraverseBetter(Tree root) {
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack <>();
        stack.push(root);
        // 指向当前栈顶元素
        Tree peek = null;
        //刚刚打印过的元素
        Tree printed = root;
        while (!stack.isEmpty()){
            peek = stack.peek();
            //必须要设置刚刚打印的节点和左右节点都不同，不然会造成在左右节点间循环这种局面
            if(peek.left != null && printed != peek.left && printed != peek.right){
                stack.push(peek.left);
            }else if(peek.right != null && printed != peek.right){
                stack.push(peek.right);
            }else{
                printed = stack.pop();
                System.out.print(printed.value);
            }
        }
    }
    public static Tree buildTree(){
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(5);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(7);
        Tree n2 = new Tree(2, n4, n5);
        Tree n3 = new Tree(3, n6, n7);
        Tree root = new Tree(1, n2, n3);
        return root;
    }

    public static void main(String[] args) {
        Tree root = buildTree();
        preTraverse(root);
        System.out.println();
        //root = buildTree();
        //inTraverse(root);
        inTraverseBetter(root);
        System.out.println();
        //root = buildTree();
        postTraverseBetter(root);

    }
}

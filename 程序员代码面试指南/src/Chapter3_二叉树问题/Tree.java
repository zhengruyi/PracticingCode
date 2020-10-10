package Chapter3_二叉树问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 21:31
 **/

public class Tree {
    public  int value;
    public Tree left;
    public Tree right;
    public Tree(int value){
        this.value = value;
    }
    public Tree(int value, Tree left, Tree right){
        this.value =value;
        this.left = left;
        this.right = right;
    }
}

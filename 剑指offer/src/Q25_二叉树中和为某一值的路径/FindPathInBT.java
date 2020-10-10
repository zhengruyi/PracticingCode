package Q25_二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 20:41
 **/

public class FindPathInBT {
    public static void findPath(Tree root, int target) {
        if(root == null || target < 0)
            return;
        ArrayList<Integer> path = new ArrayList <>();
        int currentSum = 0;
        find(root, target, path, currentSum);
    }

    public static void find(Tree root, int target, ArrayList<Integer> path, int currentSum) {
        if(root.left == null && root.right == null){
            if(currentSum + root.value == target){
                path.add(root.value);
                printPath(path);
                path.remove(path.size()-1);
                return ;
            }else
                return;
        }

        if(currentSum + root.value > target)
            return;
        path.add(root.value);
        currentSum += root.value;

        find(root.left, target, path, currentSum);
        find(root.right, target, path,currentSum);

        path.remove(path.size() - 1);
        currentSum -= root.value;
    }

    public static void printPath(ArrayList path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.printf("%d ", path.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Tree leaf4 = new Tree(4,null,null);
        Tree leaf7 = new Tree(7, null, null);
        Tree t5 = new Tree(5,leaf4,leaf7);
        Tree t12 = new Tree(12,null,null);
        Tree root = new Tree(10,t5,t12);
        findPath(root,22);
        findPath(root,19);
        findPath(root,35);
    }
}

class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
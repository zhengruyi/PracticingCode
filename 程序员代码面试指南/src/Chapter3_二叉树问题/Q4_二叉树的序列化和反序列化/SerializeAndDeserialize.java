package Chapter3_二叉树问题.Q4_二叉树的序列化和反序列化;

import Chapter3_二叉树问题.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/05/2020 17:12
 **/

public class SerializeAndDeserialize{
    public static String serialize(Tree root){
        if(root == null){
            return null;
        }
        Deque<Tree> deque = new ArrayDeque <>();
        Tree empty = new Tree(-1);
        deque.addLast(root);
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()){
            Tree temp = deque.removeFirst();
            builder.append(temp != empty ? temp.value : "#");
            builder.append('!');
            if(temp != empty){
                deque.addLast(temp.left != null ? temp.left : empty);
                deque.addLast(temp.right != null ? temp.right : empty);
            }
        }
        return builder.toString();
    }
    public static Tree deserialize(String input){
        if(input == null || input.length() == 0){
            return null;
        }
        String[] values = input.split("!");
        int index = 0;
        Tree root = generateNode(values[index++]);
        if(root == null){
            return null;
        }
        Deque<Tree> deque = new ArrayDeque <>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            Tree node = deque.removeFirst();
            node.left = generateNode(values[index++]);
            node.right = generateNode(values[index++]);
            if(node.left != null){
                deque.addLast(node.left);
            }
            if(node.right != null){
                deque.addLast(node.right);
            }
        }
        return root;
    }
    public static Tree generateNode(String value){
        if(value.equals("#")){
            return null;
        }
        return new Tree(Integer.parseInt(value));
    }

    public static void main(String[] args) {
        Tree t5 = new Tree(5);
        Tree t4 = new Tree(4);
        Tree t2 = new Tree(2,t4,null);
        Tree t3 = new Tree(3,null,t5);
        Tree t1 = new Tree(1,t2,t3);
        String result = serialize(t1);
        System.out.println(result);
        deserialize(result);
    }
}

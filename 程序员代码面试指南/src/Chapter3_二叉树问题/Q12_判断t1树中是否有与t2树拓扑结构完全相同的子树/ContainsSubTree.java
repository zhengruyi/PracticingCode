package Chapter3_二叉树问题.Q12_判断t1树中是否有与t2树拓扑结构完全相同的子树;

import Chapter3_二叉树问题.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 16:04
 **/

public class ContainsSubTree {
    public static boolean contains(Tree t1, Tree t2){
        if(t1 == null || t2 == null){
            return  false;
        }
        StringBuilder builder = new StringBuilder();
        String parent = serialize(t1,builder).toString();

        builder.delete(0,builder.length());
        String sub = serialize(t2,builder).toString();
        return findSubString(parent,sub);
    }
    public static boolean findSubString(String parent, String sub){
        int index = 0;
        boolean result =false;
        while (index < parent.length()){
            int i = 0;
            while (i< sub.length() && parent.charAt(index + i) == sub.charAt(i)){
                i++;
            }
            if(i == sub.length()){
                result = true;
                break;
            }else{
                int offset = calculateOffset(sub,i);
                index = index + (offset == 0 ? 1 : offset);
            }
        }
        return result;
    }
    public static  int calculateOffset(String sub, int sameIndex){
        if(sameIndex == 0 || sameIndex == 1){
            return 0;
        }
        Set<String> preSet = new HashSet <>();
        Set<String> postSet = new HashSet <>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sameIndex; i++) {
            builder.append(sub.charAt(i));
            preSet.add(builder.toString());
        }
        builder.delete(0,builder.length());
        for (int i = sameIndex - 1; i > 0; i--) {
            builder.append(sub.charAt(i));
            postSet.add(builder.reverse().toString());
            builder.reverse();
        }
        preSet.retainAll(postSet);
        Iterator<String> it = preSet.iterator();
        int maxLength = 0;
        if(it.hasNext()){
            maxLength = Math.max(maxLength,it.next().length());
        }
        return sameIndex - maxLength;
    }
    public static StringBuilder serialize(Tree root, StringBuilder builder){
        if(root == null){
            builder.append("#");
            builder.append("!");
            return builder;
        }
        builder.append(root.value);
        builder.append("!");
        serialize(root.left,builder);
        serialize(root.right,builder);
        return builder;
    }

    public static void main(String[] args) {
        Tree t8 = new Tree(8);
        Tree t9 = new Tree(9);
        Tree t4 = new Tree(4,null,t8);
        Tree t5 = new Tree(5,t9,null);
        Tree t2 = new Tree(2,t4,t5);
        Tree t6 = new Tree(6);
        Tree t7 = new Tree(7);
        Tree t3 = new Tree(3,t6,t7);
        Tree t1 = new Tree(1,t2,t3);

        Tree m8 = new Tree(8);
        Tree m9 = new Tree(9);
        Tree m4 = new Tree(4,null,m8);
        Tree m5 = new Tree(5,m9,null);
        Tree m2 = new Tree(2,m4,m5);

        System.out.println(contains(t1,m2));
        m5.left = null;
        System.out.println(contains(t1,m2));

        System.out.println(findSubString("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
        System.out.println(findSubString("BBC ABCDAB ABCDABCDABDE","ABCDABC"));
    }
}

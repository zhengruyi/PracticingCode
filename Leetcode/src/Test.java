import Chapter13_二叉树.TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    static IntFunction<BigInteger> fact = null;
    public static List <Integer> getRow(int rowIndex) {
        List <Integer> list = new ArrayList <Integer>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                if (j == i) {
                    list.add(list.get(j) + 1);
                } else {
                    list.set(j, list.get(j) + list.get(j - 1));
                }
            }
        }
        list.add(1);
        return list;
    }
    static boolean loop() { return loop(); }
    static boolean or(BooleanSupplier b1, BooleanSupplier b2) { return b1.getAsBoolean() || b2.getAsBoolean(); }
    public static TreeNode deserialize(String data) {
        String[] datas = data.split("#");
        int len = datas.length;
        TreeNode[] trees = new TreeNode[datas.length];
        for(int i = 0; i < len; i++){
            if("null".equals(datas[i])){
                trees[i] = null;
            }else{
                trees[i] = new TreeNode(Integer.parseInt(datas[i]));
            }
        }
        for(int i =0; i < trees.length;i++){
            if((2 * i + 1) < len && trees[i] != null){
                trees[i].left = trees[2*i+1];
            }
            if((2 * i + 2) < len && trees[i] != null){
                trees[i].right = trees[2*i+2];
            }
        }
        return trees[0];
    }
    public static void main(String[] args) {
        TreeNode root = deserialize("1#2#3#null#null#4#5#6#7#null#null#null#null#null#null#");
        System.out.println(root);
    }
}

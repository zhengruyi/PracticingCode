package Chapter14_深度搜索和广度搜索.Q1104_二叉树寻路;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/02/2021 23:20
 **/

public class Solution {
    public List <Integer> pathInZigZagTree(int label) {
        LinkedList <Integer> res = new LinkedList<Integer>();
        //计算树的深度
        int depth = (int)(Math.log(label) / Math.log(2));
        while(label > 1){
            //倒序添加
            res.addFirst(label);
            //重点:每行的坐标的起点是 2^n, 然后这行的节点数目也是2^n，那么这行最后一个节点数字就是 2 * 2 ^n - 1
            //根据对称性，对称的坐标就是 3 * 2 ^ n -1 - label /2
            label = (int)(3 * Math.pow(2,--depth) - 1 - label / 2);
        }
        //添加起始点
        res.addFirst(1);
        return res;
    }
}

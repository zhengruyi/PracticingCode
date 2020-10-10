package Chapter2_贪心算法.Q3_哈夫曼编码;

import java.nio.Buffer;
import java.sql.DataTruncation;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/07/2020 10:25
 **/

public class HuffmanCode {
    public static void buildHuffmanTree(HuffmanNode[] nodes){
        int nums = nodes.length;
        int index = nums;
        HuffmanNode[] completeHuffmanTree = new HuffmanNode[2*nums - 1];
        PriorityQueue<HuffmanNode> pq = new PriorityQueue <>(new Comparator <HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                if(o1.weight - o2.weight > 0.01){
                    return 1;
                }else if(o1.weight - o2.weight < -0.01){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums; i++) {
            pq.add(nodes[i]);
        }
        while (pq.size() != 1){
            HuffmanNode t1 = pq.poll();
            HuffmanNode t2 = pq.poll();
            HuffmanNode root = new HuffmanNode("",t1.weight+t2.weight);
            root.lChild = t1.weight < t2.weight ? t1 : t2;
            root.rChild = t1.weight > t2.weight ? t1 : t2;
            t1.parent = root;
            t2.parent = root;
            completeHuffmanTree[index++] = root;
            pq.add(root);
            System.out.println(" choose node t1 : "+t1 + " and t2 : "+t2);
        }
        printHuffmanCode(nodes,nums);
    }
    public static void printHuffmanCode(HuffmanNode[] coder, int nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums; i++) {
            HuffmanNode node = coder[i];
            while (node.parent != null){
                if(node.parent.lChild == node){
                    builder.append('0');
                }else{
                    builder.append('1');
                }
                node = node.parent;
            }
            System.out.println(" value : "+coder[i].value +" huffmanCode : "+builder.reverse().toString());
            builder.delete(0,builder.length());
        }
    }

    public static void main(String[] args) {
        HuffmanNode[] nodes = {
                new HuffmanNode("a",0.05),
                new HuffmanNode("b",0.32),
                new HuffmanNode("c",0.18),
                new HuffmanNode("d",0.07),
                new HuffmanNode("e",0.25),
                new HuffmanNode("f",0.13),
        };
        buildHuffmanTree(nodes);
    }
}

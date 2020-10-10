package Chapter2_贪心算法.Q3_哈夫曼编码;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/07/2020 10:21
 **/

public class HuffmanNode {
    public String value;
    public HuffmanNode parent = null;
    public HuffmanNode lChild = null;
    public HuffmanNode rChild = null;
    public double weight;

    public HuffmanNode(String value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value='" + value + '\'' +
                ", weight=" + weight +
                '}';
    }
}

package Chapter14_深度搜索和广度搜索.Q133_克隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 21:05
 **/

public class Solution {
    HashMap<Node,Node> map = new HashMap <>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    /**
     * 这里复制的关键在于避免死循环导致的内存超出
     * 所以这里先采用创建空节点在慢慢补全所有邻节点的方法
     * 另外创建哈希表来保存源节点和克隆节点
     * @param node
     * @return
     */
    public Node dfs(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node,clone);
        for(Node n : node.neighbors){
            clone.neighbors.add(dfs(n));
        }
        return clone;
    }
}
class Node {
    public int val;
    public List <Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList <Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
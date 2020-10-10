package Chapter5_字符串问题.Q22_字典树也就是前缀树的实现;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/06/2020 16:25
 **/

public class DictionaryTree {
    private TrieNode root;
    public DictionaryTree(){
        root = new TrieNode();
    }
    public void insert(String word){
        if(word == null){
            return;
        }
        char[] chas = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chas.length; i++) {
            index = chas[i] - 'a';
            if(node.map[index] == null){
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }
    public void delete(String word){
        if(search(word)){
            char[] chas = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chas.length; i++) {
                index = chas[i] - 'a';
                if(node.map[index].path-- == 1){
                    node.map[index] = null;
                    return;
                }
                node.end--;
            }
        }
    }
    public boolean search(String word){
        if(word == null){
            return false;
        }
        char[] chas = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chas.length; i++) {
            index = chas[i] - 'a';
            if(node.map[index] == null){
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre){
        if(pre == null){
            return 0;
        }
        char[] chas = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chas.length; i++) {
            index = chas[i] - 'a';
            if(node.map[index] == null){
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
}
class TrieNode{
    public int path;
    public int end;
    public TrieNode[] map;
    public  TrieNode(){
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
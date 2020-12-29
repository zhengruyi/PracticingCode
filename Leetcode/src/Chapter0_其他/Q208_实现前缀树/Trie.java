package Chapter0_其他.Q208_实现前缀树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:13
 **/

public class Trie {
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] s = word.toCharArray();
        insertWord(s);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        //找到字符串的终止节点
        for(int i = 0; i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if(tmp.childNodes[index] == null){
                return false;
            }
            tmp = tmp.childNodes[index];
        }
        //判断是否有字符串截止在这
        return tmp.freq > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        //找到前缀的终止节点
        for(int i = 0; i < prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if(tmp.childNodes[index] == null){
                return false;
            }
            if(i != prefix.length() - 1){
                tmp = tmp.childNodes[index];
            }
        }
        //判断子节点是否大于0
        return tmp.num > 0;
    }

    public void insertWord(char[] chars){
        TrieNode tmp = root;
        //由于根节点不保存任何值，所以都是在当前节点处理子节点的情况
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            //如果子节点为null,那么久新建节点
            if(tmp.childNodes[index] == null){
                TrieNode node = new TrieNode();
                node.nodeChar = chars[i];
                tmp.childNodes[index] = node;
                //子节点数目加1
                tmp.num++;
            }
            tmp = tmp.childNodes[index];
            //如果这个节点时终止节点，那么freq+1
            if(i == chars.length - 1){
                tmp.freq++;
            }
        }
    }
}
class TrieNode{
    //保存子节点的数组
    public TrieNode[] childNodes;
    //当前节点的字符值
    public char nodeChar;
    //以当前节点的值为终止节点的字符串个数
    public int freq;
    //当前拥有的子节点个数，在前缀搜索时有用
    int num = 0;
    public TrieNode(){
        freq = 0;
        childNodes = new TrieNode[26];
    }
}
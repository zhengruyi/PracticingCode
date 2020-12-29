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
        for(int i = 0; i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if(tmp.childNodes[index] == null){
                return false;
            }
            tmp = tmp.childNodes[index];
        }
        return tmp.freq > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i = 0; i < prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if(tmp.childNodes[index] == null){
                return false;
            }
            if(i != prefix.length() - 1){
                tmp = tmp.childNodes[index];
            }
        }
        return tmp.num > 0;
    }

    public void insertWord(char[] chars){
        TrieNode tmp = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(tmp.childNodes[index] == null){
                TrieNode node = new TrieNode();
                node.nodeChar = chars[i];
                tmp.childNodes[index] = node;
                tmp.num++;
            }
            tmp = tmp.childNodes[index];
            if(i == chars.length - 1){
                tmp.freq++;
            }
        }
    }
}
class TrieNode{
    public TrieNode[] childNodes;
    public char nodeChar;
    public int freq;
    int num = 0;
    public TrieNode(){
        freq = 0;
        childNodes = new TrieNode[26];
    }
}
package Chapter0_其他.Q820_单词的压缩编码;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 17:47
 **/

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0){
            return 0;
        }
        int res = 0;
        Trie trie = new Trie();
        //按字符串长度从大到小排列，因为这样可以将检测出较小的字符串是否是另一个字符串的前缀或者后缀
        Arrays.sort(words,(s1, s2) -> s2.length() - s1.length());
        //将字符串插入字典树中
        for(int i = 0; i < words.length; i++){
            res += trie.insert(words[i]);
        }
        return res;
    }
}

/**
 * 字典树结构，常用于检测某个字符串是否是某些字符串的前缀(正向遍历)或者后缀(反向遍历)
 */
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public int insert(String s){
        TrieNode curr = root;
        boolean isNew = false;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            //说明字符串不是所有已经添加字符串的后缀
            //后缀是因为反向遍历字符串
            if(curr.children[c - 'a'] == null){
                isNew = true;
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        //如果不收某个字符串的子串，那么就需要为压缩后的字符串添加s.length()+1长度
        return isNew ? s.length()+1 : 0;
    }
}
class TrieNode{
    public char val;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}

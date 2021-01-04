package Chapter16_高级数据结构.Q648_单词替换;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/01/2021 21:10
 **/

public class Solution {
    public String replaceWords(List <String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        //将字典中的所有单词都放入前缀树中
        for(String word : dictionary){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.word = word;
        }
        StringBuilder builder = new StringBuilder();
        //这里\\s+表示匹配多个空白字符\s表示空白字符,+表示匹配一次或者多次
        for(String s : sentence.split("\\s+")){
            TrieNode curr = root;
            if(builder.length() > 0){
                builder.append(" ");
            }
            for(char c : s.toCharArray()){
                //单词沿着前缀树遍历到底了或者已经找到了符合要求的前缀，那么就要跳出循环
                if(curr.children[c-'a'] == null || curr.word != null){
                    break;
                }
                curr = curr.children[c-'a'];
            }
            builder.append(curr.word == null ? s : curr.word);
        }
        return builder.toString();
    }
}

/**
 * 前缀树用来确认某个字符串是否是另一个字符串的前缀
 */
class TrieNode{
    public String word;
    public TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
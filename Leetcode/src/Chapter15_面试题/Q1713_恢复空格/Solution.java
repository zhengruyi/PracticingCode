package Chapter15_面试题.Q1713_恢复空格;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/02/2021 23:47
 **/

public class Solution {
    TrieNode root;
    public int respace(String[] dictionary, String sentence) {
        if(sentence.length() == 0){
            return 0;
        }
        int len = sentence.length();
        //dp[i]表示sentence以i..末尾的的句子的陌生字符数目
        int[] dp = new int[len + 1];
        root  = new TrieNode();
        //将可能的单词构建成字典树
        makeTrieTree(dictionary);
        //从末尾倒序遍历可能性,因为要用到dp[i+1]所以i+1要先计算
        for(int i = len - 1; i >= 0; i--){
            //首先假设所有字符都是陌生的
            dp[i] = len - i;
            TrieNode head = root;
            for(int j = i; j < len; j++){
                //计算在字典树的子节点索引
                int index = sentence.charAt(j) - 'a';
                //说明i..j的单词不存在,那么总的数目等于i..j总共j-i+1再加上dp[j+1]的数目
                if(head.children[index] == null){
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j+1]);
                    break;
                }
                //说明i..j是一个有效单词
                if(head.children[index].isWord){
                    dp[i] = Math.min(dp[i],dp[j+1]);
                }else{
                    //计算较小的陌生字符数目
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j+1]);
                }
                //递归遍历下一个字典树的节点
                head = head.children[index];
            }
        }
        return dp[0];
    }
    public void makeTrieTree(String[] dictionary){
        for(String s : dictionary){
            TrieNode head = root;
            for(int i = 0; i < s.length(); i++){
                int index = s.charAt(i) - 'a';
                if(head.children[index] == null){
                    head.children[index] = new TrieNode();
                }
                head = head.children[index];
            }
            head.isWord = true;
        }
    }
}

/**
 * 构建字典树
 */
class TrieNode{
    public TrieNode[] children;
    public boolean isWord;
    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }
}
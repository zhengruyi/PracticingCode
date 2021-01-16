package Chapter0_其他.Q792_匹配子序列的单词数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:16
 **/

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        ArrayList <Node>[] nodes = new ArrayList[26];
        //构建空列表数组
        for(int i = 0; i < 26; i++){
            nodes[i] = new ArrayList<>();
        }
        //但要单词的首字母进行分组，同一个开头字母的单词
        //分到一组
        for(String w : words){
            nodes[w.charAt(0) - 'a'].add(new Node(w,0));
        }
        for(int i = 0; i < s.length(); i++){
            //取出目标单词应位置的字符，然后从分组列表中取出对应的一组
            //此时说明已经有一个字符匹配上了，后续进行后面的字符的匹配
            List <Node> tmp = nodes[s.charAt(i) - 'a'];
            //创建一个空的链表来填补空缺
            nodes[s.charAt(i) - 'a'] = new ArrayList<>();
            for(Node n : tmp){
                //根据分组链表的单词的下一个字符，将单词重新放入到其他分组中
                n.index++;
                //如果单词已经匹配完那么就是元字符串的一个子序列
                if(n.index == n.word.length()){
                    ans++;
                }else{
                    nodes[n.word.charAt(n.index) - 'a'].add(n);
                }
            }
            tmp.clear();
        }
        return ans;
    }
}
class Node{
    public String word;
    public int index;
    public Node(String w, int i){
        this.word = w;
        this.index = i;
    }
}
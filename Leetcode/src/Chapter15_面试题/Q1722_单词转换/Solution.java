package Chapter15_面试题.Q1722_单词转换;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/03/2021 22:55
 **/

public class Solution {
    /**
     * 存储已经遍历过的节点
     */
    List <String> history = new ArrayList();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return new ArrayList();
        }
        int len = wordList.size();
        List<String> path = new ArrayList();
        if(dfs(beginWord,endWord,wordList,path)){
            path.add(0,beginWord);
        }
        return path;
    }
    public boolean dfs(String s, String endWord, List<String> wordList,List<String> path){
        if(s.equals(endWord)){
            return true;
        }
        if (!wordList.contains(endWord) || history.contains(s)){
            return false;
        }
        for(int i = 0; i < wordList.size(); i++){
            String t = wordList.get(i);
            if(dist(s,t)){
                //回溯遍历所有的可能性
                wordList.remove(i);
                path.add(t);
                if(dfs(t,endWord,wordList,path)){
                    return true;
                }
                //所有以t为起点的单词都不可能到达终点
                history.add(t);
                path.remove(path.size() -1);
                wordList.add(i,t);
            }
        }
        return false;
    }
    public boolean dist(String s,String d){
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            diff += (s.charAt(i) == d.charAt(i) ? 0 : 1);
        }
        return diff == 1;
    }
}

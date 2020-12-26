package Chapter14_深度搜索和广度搜索.Q127_单词接龙;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:25
 **/

public class Solution {
    /**
     * 用广度遍历来解决中情况，第一次遍历到结束位置，得到的就是最少转移步数
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List <String> wordList) {
        Queue <String> queue = new LinkedList <>();
        queue.offer(beginWord);
        //记录是否访问过，不然会出现来回遍历的问题
        boolean[] used = new boolean[wordList.size()];
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i++){
                String s = queue.poll();
                //如果到达目的地，因为step未考虑初始单词，所以这里要+1
                if(s.equals(endWord)){
                    return step+1;
                }
                for(int j = 0; j < wordList.size(); j++){
                    //如果这个单词未遍历过并且和当前起始单词只有一个字符不同
                    //那么就可以将这个单词入队
                    if(!used[j] && getDifference(s,wordList.get(j)) == 1){
                        used[j] = true;
                        queue.offer(wordList.get(j));
                    }
                }
            }
            step++;
        }
        return 0;
    }
    public int getDifference(String s1, String s2){
        int diff = 0;
        for( int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}

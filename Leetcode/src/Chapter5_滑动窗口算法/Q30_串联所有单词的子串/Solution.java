package Chapter5_滑动窗口算法.Q30_串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/12/2020 22:33
 **/

public class Solution {
    public List <Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList <>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        Map <String,Integer> map = new HashMap <String,Integer>();
        //记录单词组中每个不同单词的出现次数
        for(String t : words){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        //由于每个单词的长度相同，所以只用记录一个单词的长度就可以
        int oneWordLength = words[0].length();
        //记录单词组中的单词数目
        int num = words.length;
        //子串的总长度
        int allLength = num * oneWordLength;
        for(int i = 0; i < oneWordLength; i++){
            //从第一个字符串的第一个字符开始算，这里的i代表偏移量
            int left = i, right = i, count = 0;
            HashMap<String,Integer> tmp = new HashMap<>();
            //以单词长度为基本单位，不停获取下一个单词
            while(right + oneWordLength <= s.length()){
                //获取下一个单词
                String w = s.substring(right,right+oneWordLength);
                //更新右边节点的位置
                right+=oneWordLength;
                //如果出现一个不再words数组中出现的字符串
                if(!map.containsKey(w)){
                    //清空所有left开始到right统计的结果
                    count = 0;
                    left = right;
                    tmp.clear();
                }else{
                    //更新窗口中出现的字符串种类和数目
                    tmp.put(w,tmp.getOrDefault(w,0)+1);
                    count++;
                    //如果某一个字符串的出现次数超出了目标，奶茶么开始收缩左边界，同时更新窗口中的统计结果
                    while(tmp.get(w) > map.get(w)){
                        String t = s.substring(left,left+oneWordLength);
                        count--;
                        tmp.put(t,tmp.get(t) - 1);
                        left += oneWordLength;
                    }
                    //如果所有都匹配，那么找到起始索引
                    if(count == num){
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}

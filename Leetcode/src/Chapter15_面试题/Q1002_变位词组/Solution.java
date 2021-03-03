package Chapter15_面试题.Q1002_变位词组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/03/2021 23:01
 **/

public class Solution {
    /**
     * 变位词组排序后否是同一个单词
     * @param strs
     * @return
     */
    public List<List <String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();
        for(String s : strs){
            char[] chas = s.toCharArray();
            Arrays.sort(chas);
            String sorted = new String(chas);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList <String>());
            }
            map.get(sorted).add(s);
        }
        List<List<String>> res = new ArrayList();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}

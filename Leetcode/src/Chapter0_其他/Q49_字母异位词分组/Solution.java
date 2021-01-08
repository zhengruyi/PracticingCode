package Chapter0_其他.Q49_字母异位词分组;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/01/2021 22:57
 **/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList <>();
        if(strs.length == 0){
            return res;
        }
        Map <String, List <String>> map = new HashMap <>();
        for(String str : strs){
            //对异位词进行排序，从而保证所偶遇异位词会被归类到一个列表中
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(key,tmp);
            }
        }
        //最后将遍历哈希表将结果返回
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}

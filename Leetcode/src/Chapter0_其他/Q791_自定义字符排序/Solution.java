package Chapter0_其他.Q791_自定义字符排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:17
 **/

public class Solution {
    public String customSortString(String S, String T) {
        Map <Character,Integer> map = new HashMap <Character,Integer>();
        //统计S字符串中各个字符的出现次序
        for(int i = 0; i < S.length();i++){
            //记录字符和索引的关系
            map.put(S.charAt(i),i);
        }
        //因为后面要排序，所以只能手动转成Character[]数组
        Character[] tmp = new Character[T.length()];
        for(int i = 0; i < T.length();i++){
            tmp[i] = T.charAt(i);
        }
        //按照hash表里面的索引值进行排序，对于未在hashMap边里面的数字，统计移动最后面
        Arrays.sort(tmp, new Comparator <Character>(){
            @Override
            public int compare(Character a, Character b){
                return map.getOrDefault(a,Integer.MAX_VALUE) - map.getOrDefault(b,Integer.MIN_VALUE);
            }
        });
        //将排序后的数组拼成字符串返回
        StringBuilder builder = new StringBuilder();
        for(Character c : tmp){
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 采用统计计数的方法来进行统计
     * @param S
     * @param T
     * @return
     */
    public String customSortString2(String S, String T) {
        // count[char] = the number of occurrences of 'char' in T.
        // This is offset so that count[0] = occurrences of 'a', etc.
        // 'count' represents the current state of characters
        // (with multiplicity) we need to write to our answer.
        int[] count = new int[26];
        for (char c: T.toCharArray())
            count[c - 'a']++;

        // ans will be our final answer.  We use StringBuilder to join
        // the answer so that we more efficiently calculate a
        // concatenation of strings.
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}

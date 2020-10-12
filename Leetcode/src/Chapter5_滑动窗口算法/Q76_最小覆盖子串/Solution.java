package Chapter5_滑动窗口算法.Q76_最小覆盖子串;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 21:46
 **/

public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        //统计目标子串的各个字符的出现次数
        HashMap <Character, Integer> target = new HashMap<Character,Integer>();
        //统计窗口中的个字符出现次数
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < t.length();i++){
            target.put(t.charAt(i),target.getOrDefault(t.charAt(i),0)+1);
        }
        int nums = target.size();
        int count = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        while(right < chars.length){
            char c = chars[right];
            map.put(c,map.getOrDefault(c,0)+1);
            right++;
            //当窗口内一个字符数目达到要求时，则加一表示完成一项
            if(map.get(c).equals(target.get(c))){
                count++;
            }
            //表示窗口内包含了所有的目标字符。开始收缩左边界
            while(count == nums){
                //如果当前子串符合条件且更短时则更新目标长度和起始点
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                //取出左边界，进行对应更新
                char tmp = chars[left];
                left++;
                //如果原来数目符合要求，现在减去1则不再符合要求，count --
                if(map.get(tmp).equals(target.get(tmp))){
                    count--;
                }
                map.put(tmp,map.get(tmp) -1);
            }
        }
        return start == -1 ? "" : s.substring(start,start+minLen);
    }
}

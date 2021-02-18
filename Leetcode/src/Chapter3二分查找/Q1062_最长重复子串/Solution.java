package Chapter3二分查找.Q1062_最长重复子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/02/2021 22:30
 **/

public class Solution {
    /**
     * 如果长度为s的字符串存在重复子串,那么长度为s+1的重复子串也可能存在,
     * 采用二分法来确定重复子串的长度
     * @param s
     * @return
     */
    public int longestRepeatingSubstring(String s) {
        int left = 1;
        int right = s.length();
        int res = 0;
        //二分法确定重复字串长度
        while(left <= right){
            int mid = left +(right - left) /2;
            //字符串长度可以更大
            if(search(mid,s)){
                left = mid + 1;
                res = Math.max(res,mid);
            }else{
                //缩小字符串长度
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 通过集合来确定在指定长度下是否存在重复字符串
     * @param len
     * @param s
     * @return
     */
    public boolean search(int len,String s){
        Set <String> set = new HashSet();
        for(int i = 0; i < s.length() - len + 1; i++){
            String t = s.substring(i,i+len);
            if(set.contains(t)){
                return true;
            }else{
                set.add(t);
            }
        }
        return false;
    }
}

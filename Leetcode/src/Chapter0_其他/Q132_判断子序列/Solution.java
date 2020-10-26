package Chapter0_其他.Q132_判断子序列;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/10/2020 12:35
 **/

public class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] charsT = t.toCharArray();
        HashMap <Character, ArrayList <Integer>> map = new HashMap<>();
        //统计t字符串中个字符的出现位置
        for(int i = 0; i < charsT.length; i++){
            if(!map.containsKey(charsT[i])){
                map.put(charsT[i], new ArrayList<Integer>());
            }
            map.get(charsT[i]).add(i);
        }
        // j是在原字符串的下标
        int j =0;
        char[] chars = s.toCharArray();
        for(int i =0; i < chars.length; i++){
            if(!map.containsKey(chars[i])){
                return false;
            }
            ArrayList<Integer> list = map.get(chars[i]);
            //左边界二分搜索的性质，如果要搜索的数字不存在数组中，则二分搜索的结果会指向第一个比目标值大的索引处
            int index = leftBound(list,j);
            //如果 index == list.size(), 那么代表原字符串中不存在对应字符，返回false
            if(index == list.size()){
                return false;
            }
            j = list.get(index)+ 1;

        }
        return true;
    }
    //二分搜索的左边界方法
    public int leftBound(ArrayList<Integer> list, int current){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = left + (right - left )/2;
            if(list.get(mid) < current){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

import Chapter13_二叉树.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    static String[] strs;
    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(0,strs.length - 1);
        StringBuilder builder = new StringBuilder();
        boolean isFirstZero = true;
        for(int i =0; i < strs.length; i++){
            if(isFirstZero && strs[i].equals("0")){
                continue;
            }
            builder.append(strs[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();

    }
    public static void quickSort(int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        String threshold = strs[left];
        while(left < right){
            while(compare(strs[right],threshold) && left < right){
                right--;
            }
            if(left < right){
                strs[left] = strs[right];
                left++;
            }
            while(!compare(strs[left],threshold) && left < right){
                left++;
            }
            if(left < right){
                strs[right] = strs[left];
                right--;
            }
        }
        strs[left] = threshold;
        quickSort(start,left);
        quickSort(left+1, end);
    }
    public static boolean compare(String s1, String s2){
        return (s1+s2).compareTo(s2+s1) <= 0;
    }
    public static void main(String[] args) {
        String s = "192.168.0.1";
        String[] strs = s.split("\\.");
        for(String ss : strs){
        }
    }
}

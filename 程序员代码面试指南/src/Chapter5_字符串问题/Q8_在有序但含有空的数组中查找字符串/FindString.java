package Chapter5_字符串问题.Q8_在有序但含有空的数组中查找字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/06/2020 20:12
 **/

public class FindString {
    public int findString(String[] arr, String target) {
        if (arr == null || arr.length == 0 || target == null) {
            return -1;
        }
        return find(arr, target, 0, arr.length - 1);
    }

    public int find(String[] arr, String target, int start, int end) {
       int res = -1;
       int left = start;
       int right = end;
       int mid = 0;
       int i = 0;
       while (left <= right){
           mid = (left + right) / 2;
           if(arr[mid] != null && arr[mid].equals(target)){
               res = mid;
               right = mid -1;
           }else if(arr[i] != null){
               if(arr[i].compareTo(target) > 0){
                   right = mid -1;
               }else{
                   left = mid +1;
               }
           }else{
               i = mid;
               while (arr[i] == null && --i >= left){

               }
               if(i < left || arr[i].compareTo(target) < 0){
                   left = mid +1;
               }else{
                   right = i - 1;
               }
           }
       }
       return res;
    }
    @Test
    void test(){
        String[] strs = {null,"a","null","a",null,"b",null,"c"};
        Assertions.assertEquals(1,findString(strs,"a"));
        Assertions.assertEquals(-1,findString(strs,null));
        Assertions.assertEquals(-1,findString(strs,"d"));
    }
}

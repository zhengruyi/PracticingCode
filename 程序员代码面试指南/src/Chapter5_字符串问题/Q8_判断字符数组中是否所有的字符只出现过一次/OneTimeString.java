package Chapter5_字符串问题.Q8_判断字符数组中是否所有的字符只出现过一次;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 21:49
 **/

public class OneTimeString {
    public boolean checkString(String s){
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            if(set.contains(chars[i])){
                return  false;
            }
            set.add(chars[i]);
        }
        return  true;
    }
    public boolean isUnique(String s){
        if (s == null){
            return true;
        }
        char[] chas = s.toCharArray();
        heapSort(chas);
        for (int i = 1; i < chas.length; i++) {
            if(chas[i-1] == chas[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 非递归堆排序，空间复杂度为O(1)
     * @param chas
     */
    public static void heapSort(char[] chas){
        for (int i = 0; i < chas.length; i++) {
            heapInsert(chas,i);
        }
        for (int i = chas.length -1; i >= 0 ; i--) {
            swap(chas,0,i);
            heapify(chas,0,i);
        }
    }
    public static void heapInsert(char[] chas, int i){
        int parent = 0;
        while (i != 0){
            parent = (i-1)/2;
            if(chas[parent] < chas[i]){
                swap(chas,parent,i);
                i = parent;
            }else{
                break;
            }
        }
    }
    public static void heapify(char[] chas, int i, int size){
        int left = i*2 +1;
        int right = i *2 +2;
        int largest = i;
        while (left < size){
            if(chas[left] > chas[i]){
                largest = left;
            }
            if(right < size && chas[right] >= chas[largest]){
                largest = right;
            }
            if(largest != i){
                swap(chas,largest,i);
            }else {
                break;
            }
            i = largest;
            left = i*2 +1;
            right = i *2 +2;
        }
    }
    public static void swap(char[] chas,int index1, int index2){
        char tmp = chas[index1];
        chas[index1] = chas[index2];
        chas[index2] = tmp;
    }

    public static void main(String[] args) {
        String s = "adhcsgvccdsgtdesjcdbhjahssaccs";
        char[] chars = s.toCharArray();
        heapSort(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

    }

}

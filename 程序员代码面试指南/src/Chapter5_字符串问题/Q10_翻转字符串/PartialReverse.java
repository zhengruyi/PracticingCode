package Chapter5_字符串问题.Q10_翻转字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/06/2020 09:50
 **/

public class PartialReverse {
    public static void partialReverse(char[] chars, int size){
        if(chars == null || chars.length == 0){
            return;
        }
        reverse(chars,0,size-1);
        reverse(chars,size,chars.length -1);
        reverse(chars,0,chars.length -1);
    }


    public static void reverse(char[] chas, int start, int end){
        while (start <= end){
            char tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] chars = "ABCDE".toCharArray();
        partialReverse(chars,3);
        System.out.println(String.valueOf(chars));
    }
}


package Chapter5_字符串问题.Q10_翻转字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/06/2020 22:38
 **/

public class ReverseString {
    public static void reverseString(char[] chas){
        if(chas == null || chas.length == 0){
            return;
        }
        reverse(chas,0,chas.length-1);
        int start = 0;
        boolean  founded = false;
        for (int i = 0; i < chas.length; i++) {
            if(chas[i] != ' ' && !founded){
                start = i;
                founded = true;
            }else if(chas[i] == ' '){
                reverse(chas,start,i-1);
                founded = false;
            }
        }
        if(founded){
            reverse(chas,start,chas.length -1);
        }
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
        char[] res = "dog loves pig".toCharArray();
        reverseString(res);
        System.out.println(String.valueOf(res));
        res = " I'm a student. ".toCharArray();
        reverseString(res);
        System.out.println(String.valueOf(res));
    }
}

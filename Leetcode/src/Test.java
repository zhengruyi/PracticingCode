import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static void main(String[] args) {
        findTheLongestSubstring("biaa");
    }
    public static int findTheLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] statu = new int[1 << 5];
        Arrays.fill(statu,-1);
        statu[0] = 0;
        int count = 0;
        int res = 0;
        for(int i =0; i < chas.length; i++){
            if(chas[i] == 'a'){
                count ^= (1 << 0);
            }else if(chas[i] == 'e'){
                count ^= (1 << 1);
            }else if(chas[i] == 'i'){
                count ^= (1 << 2);
            }else if(chas[i] == 'o'){
                count ^= (1 << 3);
            }else if(chas[i] == 'u'){
                count ^= (1 << 4);
            }
            if(statu[count] >= 0){
                res = Math.max(res, i+1 - statu[count]);
            }else{
                statu[count] = i+1;
            }
        }
        return res;
    }
}

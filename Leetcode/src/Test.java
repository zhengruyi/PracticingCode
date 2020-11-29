import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0){
            return s;
        }
        s = new StringBuilder(s).reverse().toString();
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int i = 0;
        for(i = 0; i <s.length();i++){
            if(s.charAt(i) == ' '){
                if(i - start > 1){
                    builder.append(new StringBuilder(s.substring(start,i)).reverse().toString());
                    builder.append(' ');
                }
                start = i;
            }
        }
        if(i - start > 1){
            builder.append(new StringBuilder(s.substring(start,i)).reverse().toString());
        }

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2,3},{4,5,6},{7,8,9}};
        reverseWords("the sky is blue");
    }
}

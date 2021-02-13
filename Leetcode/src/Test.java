import Chapter13_二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        backspaceCompare("y#fo##f"
                ,"y#f#o##f");
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    int[] dx = {-2,-2,-1,-1,1,1,2,2};
    int[] dy = {1,-1,2,-2,2,-2,1,-1};
    public boolean backspaceCompare(String S, String T) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#' && builder.length() > 0){
                builder.deleteCharAt(builder.length() - 1);
            }else{
                builder.append(S.charAt(i));
            }
        }
        String s1 = builder.toString();
        builder.delete(0,builder.length());
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) == '#' && builder.length() > 0){
                builder.deleteCharAt(builder.length() - 1);
            }else{
                builder.append(T.charAt(i));
            }
        }
        return builder.toString().equals(s1);
    }
    public int getDistance(int[] x1, int[] y1){
        return Math.abs(x1[0] - y1[0]) + Math.abs(x1[1] - y1[1]);
    }
}
class Allocation{
    public int workerId;
    public int bikeId;
    public int distance;
    public Allocation(int workerId, int bikeId, int distance){
        this.workerId = workerId;
        this.bikeId = bikeId;
        this.distance = distance;
    }
}
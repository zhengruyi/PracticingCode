import Chapter13_二叉树.TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    static IntFunction<BigInteger> fact = null;
    public static List <Integer> getRow(int rowIndex) {
        List <Integer> list = new ArrayList <Integer>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                if (j == i) {
                    list.add(list.get(j) + 1);
                } else {
                    list.set(j, list.get(j) + list.get(j - 1));
                }
            }
        }
        list.add(1);
        return list;
    }
    static boolean loop() { return loop(); }
    static boolean or(BooleanSupplier b1, BooleanSupplier b2) { return b1.getAsBoolean() || b2.getAsBoolean(); }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });
        int n = people.length;
        int[][] res = new int[n][2];
        for(int[] person : people){
            int space = person[1] + 1;
            for(int i = 0; i < n; i++){
                if(res[i] == null){
                    --space;
                    if(space == 0){
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] nums = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(nums);
    }
}

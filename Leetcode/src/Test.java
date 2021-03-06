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
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String[] strs = s.split(",");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[]A = new int[n];
        int[] B = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            B[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> timesA = new HashMap();
        HashMap<Integer,Integer> timesB = new HashMap();
        Set<Integer> set = new HashSet();
        for(int num : A){
            timesA.put(num,timesA.getOrDefault(num,0)+1);
            set.add(num);
        }
        for(int num : B){
            timesB.put(num,timesB.getOrDefault(num,0)+1);
        }
        for(int x = 0; x < m; x++){
            int size = 0;
            for(int num : set){
                int target = (num + x) % m;
                if(timesB.containsKey(target) && timesA.get(num).equals(timesB.get(target))){
                    size++;
                }else{
                    break;
                }
            }
            if(size == set.size()){
                System.out.println(x);
                break;
            }
        }

    }
}
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
    public static boolean judgePoint24(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        for(int i : nums){
            tmp.add(i);
        }
        return judgePoint24(tmp);
    }
    public static boolean judgePoint24(List<Integer> list){
        if(list.size() == 1){
            return list.get(0) == 24;
        }
        for(int i = 0; i < list.size();i++){
            for(int j = i+1; j < list.size();j++){
                LinkedList<Integer> tmp = new LinkedList<Integer>();
                for(int k = 0; k < list.size(); k++){
                    if(k != i && k != j){
                        tmp.add(list.get(k));
                    }
                }
                int n1 = list.get(i);
                int n2 = list.get(j);
                boolean isValid = false;
                tmp.add(n1+n2);
                isValid = isValid || judgePoint24(tmp);
                tmp.removeLast();
                tmp.addLast(n1*n2);
                isValid = isValid || judgePoint24(tmp);
                tmp.removeLast();
                tmp.addLast(n1-n2);
                isValid = isValid || judgePoint24(tmp);
                tmp.removeLast();
                tmp.addLast(n2 - n1);
                isValid = isValid || judgePoint24(tmp);
                if(n1 != 0){
                    tmp.removeLast();
                    tmp.addLast(n2/n1);
                    isValid = isValid || judgePoint24(tmp);
                }
                if(n2 != 0){
                    tmp.removeLast();
                    tmp.addLast(n1/n2);
                    isValid = isValid || judgePoint24(tmp);
                }
                if(isValid){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        Arrays.sort(strs);
        for(String t : strs){
            System.out.print(t);
        }
    }
}

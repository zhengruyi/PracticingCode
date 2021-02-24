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
        canWin("++++");
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    public boolean canWin(String s) {
        if(s.length() < 2){
            return false;
        }
        return Win(s.toCharArray());
    }
    public boolean Win(char[] chas){
        for(int i = 1; i < chas.length; i++){
            if(chas[i-1] == '+' && chas[i] == '+'){
                chas[i] = '-';
                chas[i-1] = '-';
                if(!Win(chas)){
                    return true;
                }
                chas[i] = '+';
                chas[i-1] = '+';
            }
        }
        return false;
    }
}
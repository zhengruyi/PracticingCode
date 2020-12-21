import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {

    @org.junit.jupiter.api.Test
    void test(){

    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < S.length();i++){
            map.put(S.charAt(i),i);
        }
        Character[] tmp = {'a'};
        Arrays.sort(tmp,(o1,o2) -> map.getOrDefault(o1,-1) - map.getOrDefault(o2,-1));
    }

}

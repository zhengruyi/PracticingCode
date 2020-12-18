import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String t : words){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int oneWordLength = words[0].length();
        int num = words.length;
        int allLength = num * oneWordLength;
        for(int i = 0; i < oneWordLength; i++) {
            int left = i, right = i, count = 0;
            HashMap <String, Integer> tmp = new HashMap <>();
            while (right + oneWordLength <= s.length()) {
                String w = s.substring(right, right + oneWordLength);
                right += oneWordLength;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp.clear();
                } else {
                    tmp.put(w, tmp.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp.get(w) > map.get(w)) {
                        String t = s.substring(left, left + oneWordLength);
                        count--;
                        tmp.put(w, tmp.get(w) - 1);
                        left += oneWordLength;
                    }
                    if (count == num) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
    @org.junit.jupiter.api.Test
    void test(){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        findSubstring(s,words);
    }

    public static void main(String[] args) {
        int x = 46339;
        System.out.println(x*x);
    }
}

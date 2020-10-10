package Chapter5_字符串问题.Q14_公式字符串求值;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 14:18
 **/

public class GetResult {
    public int getValue(String exp) {
        return value(exp.toCharArray(), 0)[0];
    }

    public int[] value(char[] chars, int i) {
        Deque <String> deq = new LinkedList <String>();
        int pre = 0;
        int[] bra = null;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addNum(deq, pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                bra = value(chars, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(deq, pre);
        return new int[]{getNum(deq), i};
    }

    public void addNum(Deque <String> deq, int num) {
        if (!deq.isEmpty()) {
            int cur = 0;
            String top = deq.pollLast();
            if (top.equals("+") || top.equals("-")) {
                deq.addLast(top);
            }else {
                cur = Integer.valueOf(deq.pollLast());
                num = top.equals("*") ? (cur * num) : (cur/num);
            }
        }
        deq.addLast(String.valueOf(num));
    }
    public int getNum(Deque<String> deq){
        int res= 0;
        boolean add = true;
        String curr = null;
        int num = 0;
        while (!deq.isEmpty()){
            curr = deq.pollFirst();
            if(curr.equals("+")){
                add = true;
            }else if(curr.equals("-")){
                add = false;
            }else {
                num = Integer.valueOf(curr);
                res += add ? num : -num;
            }
        }
        return res;
    }
    @Test
    void test(){
        Assertions.assertEquals(-1816,getValue("48*((70-65)-43)+8*1"));
        Assertions.assertEquals(7,getValue("3+1*4"));
        Assertions.assertEquals(7,getValue("3+(1*4)"));
    }
}

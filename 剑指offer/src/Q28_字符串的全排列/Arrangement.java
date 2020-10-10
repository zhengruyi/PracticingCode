package Q28_字符串的全排列;


import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/04/2020 14:33
 **/

public class Arrangement {
    public static void getAllArrangement(String origin) {
        if (origin == null || origin.length() == 0)
            return;

        char[] chars = origin.toCharArray();
        StringBuffer buffer = new StringBuffer(chars.length);
        Stack <Integer> stack = new Stack <>();
        arrangement(chars, buffer, stack);
    }

    public static void arrangement(char[] chars, StringBuffer buffer, Stack <Integer> stack) {
        if (buffer.length() == chars.length) {
            System.out.println(buffer.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!stack.contains(i)) {
                buffer.append(chars[i]);
                stack.push(i);
                arrangement(chars, buffer, stack);
                stack.pop();
                buffer = buffer.deleteCharAt(buffer.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        getAllArrangement("abc");
        getAllArrangement("a");
    }

}

package Chapter5_字符串问题.Q9_字符串的调整与替换;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/06/2020 21:33
 **/

public class AdjustAndReplace {
    public static void replace(char[] chars){
        if(chars == null || chars.length == 0){
            return;
        }
        int num = 0;
        int len;
        for (len = 0; len < chars.length && chars[len] != '\u0000'; len++) {
            num = chars[len] == ' ' ? ++num : num;
        }
        int last = num * 2 + len - 1;
        while (last >= 0) {
            if(chars[--len] != ' '){
                chars[last--] = chars[len];
            }else{
                chars[last--] = '0';
                chars[last--] = '2';
                chars[last--] = '%';
            }
        }
    }
    public static void adjust(char[] chars){
        if(chars == null || chars.length == 0){
            return;
        }
        int j = chars.length -1;
        for (int i = chars.length -1; i >= 0 ; i--) {
            if(chars[i] != '*'){
                chars[j--] = chars[i];
            }
        }
        while (j >=0){
            chars[j--] = '*';
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[10];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[2] = ' ';
        chars[3] = 'c';
        replace(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();

        char[] nums = "12**345".toCharArray();
        adjust(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        nums = "**123**45".toCharArray();
        adjust(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}

package Chapter0_其他.Q709_转换成小写字母;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/02/2021 23:29
 **/

public class Solution {
    /**
     * 判断字符是否是大写,如果是就减去'A'和'a'之间的差值，完成大小写字符之间的转换
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        int offset = 'A' - 'a';
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] = (char)(chars[i] - offset);
            }
        }
        return new String(chars);
    }
}

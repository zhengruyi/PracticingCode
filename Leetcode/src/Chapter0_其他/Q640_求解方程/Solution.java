package Chapter0_其他.Q640_求解方程;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 22:45
 **/

public class Solution {
    /**
     * 总体思路就是根据等号将字符串分成左右两段，左边是x的系数，右边是常数
     * 注意左右边调换位置时需要翻转符号
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        //切分字符串
        String[] strs = equation.split("=");
        int lhs = 0;
        int rhs = 0;
        //处理左半边字符串
        for(String s : breakIt(strs[0])){
            //先根据运算符号将字符串打碎成多个小字符串,如果小字符串包含x那么就是加在左边常数
            if(s.indexOf("x") >= 0){
                lhs += Integer.parseInt(coeff(s));
            }else{
                //如果是常数则移动到右边，因为符号翻转变成减去
                rhs -= Integer.parseInt(s);
            }
        }
        //处理右半部分字符串,方式相同只是需要注意此时符号的左半边完全相反
        for(String s : breakIt(strs[1])){
            if(s.indexOf("x") >= 0){
                lhs -= Integer.parseInt(coeff(s));
            }else{
                rhs += Integer.parseInt(s);
            }
        }
        if(lhs == 0){
            //如果左右部分全部为0，那么有无数个解
            if(rhs == 0){
                return "Infinite solutions";
            }else{
                //等式不成立
                return "No solution";
            }
        }
        return "x="+rhs/lhs;
    }
    /**
     *根据不同的情况，如果是x则变成1，如果是nx则变成n
     */
    public String coeff(String s){
        if(s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9'){
            return s.replace("x","");
        }
        return s.replace("x","1");
    }
    /**
     *根据运算符号将长字符串打碎成nx或者常数这种字符数组
     */
    public List <String> breakIt(String s){
        List<String> res = new ArrayList <>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(builder.length() > 0){
                    res.add(builder.toString());
                    builder.delete(0,builder.length());
                }
                builder.append(s.charAt(i));
            }else{
                builder.append(s.charAt(i));
            }
        }
        res.add(builder.toString());
        return res;
    }
}

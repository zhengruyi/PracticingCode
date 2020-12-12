package Chapter0_其他.Q468_验证IP地址;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/12/2020 19:10
 **/

public class Solution {
    public String validIPAddress(String IP) {
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            return validateIPv4(IP);
        }
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            return validateIPv6(IP);
        }
        return "Neither";
    }
    public String validateIPv4(String s){
        //这里用\\.是因为.在正则表达式中有特殊意义，所以用\\来表示转义符
        String[] strs = s.split("\\.");
        if(strs.length != 4){
            return "Neither";
        }
        for(String tmp : strs){
            if(tmp.length() == 0 || tmp.length() > 3){
                return "Neither";
            }

            if(tmp.charAt(0) == '0' && tmp.length() > 1){
                return "Neither";
            }
            for(char c : tmp.toCharArray()){
                if(!Character.isDigit(c)){
                    return "Neither";
                }
            }
            if(Integer.parseInt(tmp) > 255){
                return "Neither";
            }
        }
        return "IPv4";
    }
    public String validateIPv6(String s){
        String[] strs = s.split(":");
        if(strs.length != 8){
            return "Neither";
        }
        String hex = "0123456789abcdefABCDEF";
        for(String tmp : strs){
            if(tmp.length() == 0 || tmp.length() > 4){
                return "Neither";
            }
            for(char c : tmp.toCharArray()){
                if(hex.indexOf(c) == -1){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}

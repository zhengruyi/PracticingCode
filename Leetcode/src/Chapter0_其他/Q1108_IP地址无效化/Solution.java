package Chapter0_其他.Q1108_IP地址无效化;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 21:09
 **/

public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

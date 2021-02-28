package Chapter0_其他.Q412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/02/2021 23:43
 **/

public class Solution {
    public List<String> fizzBuzz(int n) {
        List <String> res = new ArrayList();
        if(n <= 0){
            return res;
        }
        for(int i = 1; i <= n; i++){
            if(i % 5 == 0 && i % 3 == 0){
                res.add("FizzBuzz");
            }else if(i % 5 == 0){
                res.add("Buzz");
            }else if(i % 3 == 0){
                res.add("Fizz");
            }else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        for(int i = 1; i < rowIndex; i++){
            for(int j = i; j >= 1; j--){
                if(j == i){
                    list.add(list.get(j)+1);
                }else{
                    list.set(j,list.get(j)+list.get(j-1));
                }
            }
        }
        list.add(1);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,5};
        getRow(3);
    }
}

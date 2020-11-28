import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        ArrayList <int[]> list = new ArrayList<int[]>();
        int index = 0;
        while(index < intervals.length){
            int[]tmp = new int[2];
            tmp[0] = intervals[index][0];
            int end = index;
            while(index+ 1 < intervals.length && intervals[end][1] >= intervals[index+1][0] ){
                if(intervals[index][1] > intervals[index+1][1]){
                    index++;
                }else{
                    index++;
                    end = index;
                }
            }
            tmp[1] = intervals[end][1];
            index++;
            list.add(tmp);
        }
        int[][] res = new int[list.size()][2];
        for(int i =0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        merge(intervals);
    }
}

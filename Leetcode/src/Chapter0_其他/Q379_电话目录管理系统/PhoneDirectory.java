package Chapter0_其他.Q379_电话目录管理系统;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/01/2021 23:00
 **/

public class PhoneDirectory {
    /**
     * 使用集合来保存所有未分配的号码，不再集合中责代编号码已经分配出去
     */
    Set <Integer> use;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        use = new HashSet <>();
        for(int i = 0; i < maxNumbers; i++){
            use.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(use.size() == 0){
            return -1;
        }
        int num = use.iterator().next();
        use.remove(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return use.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        use.add(number);
    }
}

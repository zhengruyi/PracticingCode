package Q5_观察者模式.Observer;

import Q5_观察者模式.Subject;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:57
 **/

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

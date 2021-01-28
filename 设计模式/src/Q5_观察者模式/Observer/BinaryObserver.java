package Q5_观察者模式.Observer;

import Q5_观察者模式.Subject;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:59
 **/

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}

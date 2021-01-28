package Q5_观察者模式.Observer;

import Q5_观察者模式.Subject;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 00:01
 **/

public class OctalObserver extends Observer{
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}

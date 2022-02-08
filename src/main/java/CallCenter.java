import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {

    private final BlockingQueue<String> calls = new ArrayBlockingQueue<>(COUNT_CALLS);
    private final static int COUNT_CALLS = 60;
    private final static int PAUSE_CALLS = 1000;
    private final static int RESPONSE_TIME = 3000;

    public void incomingCall() {
        calls.add(Thread.currentThread().getName());
        System.out.println("Входящиий звонок " + Thread.currentThread().getName());
        try {
            Thread.sleep(PAUSE_CALLS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void answeringCall() {
        while (!calls.isEmpty()) {
            System.out.println("Оператор " + Thread.currentThread().getName() + " ответил на звонок " + calls.poll());
            try {
                Thread.sleep(RESPONSE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

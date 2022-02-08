import java.util.Random;

public class Main {

    private final static int COUNT_CALLS = 60;
    private final static int OPERATOR = 8;
    private final static int MAX_NUMBER_USER = 340;

    public static void main(String[] args) {
        Random random = new Random();
        CallCenter callCenter = new CallCenter();

        for (int i = 1; i <= COUNT_CALLS; i++) {
            new Thread(null, callCenter::incomingCall, "абонента № " + random.nextInt(MAX_NUMBER_USER)).start();
        }

        for (int i = 1; i <= OPERATOR; i++) {
            new Thread(null, callCenter::answeringCall, "№ " + i).start();
        }
    }
}

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public Transaction t;
    public Bank b;
    public int workerID;
    private boolean going;

    private CountDownLatch latch;

    public Worker(int is,Bank ba,CountDownLatch latch) {
        this.latch=latch;
        workerID = is;
        b=ba;
        going=true;
    }

    public void run() {
        while(going) {
            t = b.getTrans();
            if (t.getFrom() != -1) {
                while (b.accounts.get(t.getFrom()).isInUse()) {

                }
                b.accounts.get(t.getFrom()).withdraw(t.getAmount());
                while (b.accounts.get(t.getTo()).isInUse()) {

                }
                b.accounts.get(t.getTo()).deposit(t.getAmount());
            }
            else {
                latch.countDown();
                going=false;
            }
        }
    }
}

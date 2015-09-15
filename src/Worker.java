import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public Transaction t;
    public Bank b;
    public int workerID;
    public boolean started;

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(int is,Bank ba,CountDownLatch startSignal,CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        workerID = is;
        b=ba;
        started=false;
    }

    public void run() {
        try {
            if(!started) {
                startSignal.await();
                started = true;
            }

            t = b.getTrans();
            if (t.getFrom() != -1) {
                while (b.accounts.get(t.getFrom()).isInUse()) {

                }
                b.accounts.get(t.getFrom()).withdraw(t.getAmount());
                while (b.accounts.get(t.getTo()).isInUse()) {

                }
                b.accounts.get(t.getTo()).deposit(t.getAmount());
            }
            else
                doneSignal.countDown();
        }catch(InterruptedException e){}
    }
}

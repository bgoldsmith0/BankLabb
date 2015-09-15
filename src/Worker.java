import java.util.ArrayList;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public Transaction t;
    public Bank b;
    public int workerID;
    public boolean done;

    public Worker(int is, Bank ba) {
        workerID = is;
        b=ba;
        done=false;
    }

    public void run() {
        t=b.getTrans();
        if(t.getFrom()!=-1) {
            while (b.accounts.get(t.getFrom()).isInUse()) {

            }
            b.accounts.get(t.getFrom()).withdraw(t.getAmount());
            while (b.accounts.get(t.getTo()).isInUse()) {

            }
            b.accounts.get(t.getTo()).deposit(t.getAmount());
        }
        else
            done=false;
    }
}

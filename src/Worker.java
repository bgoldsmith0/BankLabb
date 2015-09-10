import java.util.ArrayList;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public Transaction t;
    public Bank b;
    public int workerID;

    public Worker(int is, Bank ba) {
        workerID = is;
        b=ba;

    }

    public void run() {
        try {
            t = b.list.take();
        }catch(java.lang.InterruptedException e){}

        while (b.accounts.get(t.getFrom()).isInUse()) {

        }
        b.accounts.get(t.getFrom()).withdraw(t.getAmount());
        while (b.accounts.get(t.getTo()).isInUse()) {

        }
        b.accounts.get(t.getTo()).deposit(t.getAmount());

    }

//    public void doT(Transaction t, ArrayList<Account> accounts) {
//        while (accounts.get(t.getFrom()).isInUse()) {
//
//        }
//        accounts.get(t.getFrom()).withdraw(t.getAmount());
//        while (accounts.get(t.getTo()).isInUse()) {
//
//        }
//        accounts.get(t.getTo()).deposit(t.getAmount());
//
//    }
}

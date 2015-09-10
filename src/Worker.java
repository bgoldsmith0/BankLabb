import java.util.ArrayList;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public Transaction toDeal;
    public ArrayList<Account> currentAccounts;
    public int workerID;

    public Worker(int is) {
        workerID = is;

    }

    public void run() {

    }

    public void doT(Transaction t, ArrayList<Account> accounts) {
        while (accounts.get(t.getFrom()).isInUse()) {

        }
        accounts.get(t.getFrom()).withdraw(t.getAmount());
        while (accounts.get(t.getTo()).isInUse()) {

        }
        accounts.get(t.getTo()).deposit(t.getAmount());

    }
}

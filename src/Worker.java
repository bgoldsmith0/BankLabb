import java.util.ArrayList;

/**
 * Created by movec_000 on 2015-09-09.
 */
public class Worker implements Runnable {
    public static ArrayList<Account> acts;
    public Transaction toDeal;
    public ArrayList<Account> accounts;
    public int workerID;

    public Worker(int is, ArrayList<Account> f) {
        workerID = is;
        accounts = f;

    }

    public void run() {

        while (accounts.get(t.getFrom()).isInUse()) {

        }
        accounts.get(t.getFrom()).withdraw(t.getAmount());
        while (accounts.get(t.getTo()).isInUse()) {

        }
        accounts.get(t.getTo()).deposit(t.getAmount());

    }
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

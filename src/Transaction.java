/**
 * Created by movec_000 on 2015-09-09.
 */
public class Transaction {
    int withdrawAccount;
    int depositAccount;
    int amount;

    public Transaction(int from,int to,int amount) {
        withdrawAccount = from;
        depositAccount = to;
        this.amount = amount;
    }

    public int getFrom() {
        return withdrawAccount;
    }

    public int getTo() {
        return depositAccount;
    }

    public int getAmount() {
        return amount;
    }
}
//
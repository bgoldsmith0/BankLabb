/**
 * Created by movec_000 on 2015-09-09.
 */
public class Account {

    public int iD;
    public int transactions = 0;
    public double balance = 0;

    public Account(int iD, double balance) {
        this.iD = iD;
        this.balance = balance;
    }

    public void deposit(double in) {
        balance = balance + in;
        transactions++;
    }

    public void withdraw(double out) {
        balance = balance - out;
        transactions++;
    }

}

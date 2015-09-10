/**
 * Created by movec_000 on 2015-09-09.
 */
public class Account {

    public int iD;
    public int transactions = 0;
    public double balance = 1000;
    public boolean inUse = false;

    public Account(int iD) {
        this.iD = iD;
        //this.balance = balance;
    }

    public void deposit(double in) {
        while (inUse) {
        }
        inUse = true;
        balance = balance + in;
        transactions++;
        inUse = false;
    }

    public void withdraw(double out) {
        while (inUse) {

        }
        inUse = true;
        balance = balance - out;
        transactions++;
        inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }

}

import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;
import java.io.File;

public class Bank{
    public ArrayBlockingQueue<Transaction> list = new ArrayBlockingQueue<Transaction>(100000);
    public ArrayList<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {
        Bank bank = new Bank();

        try{
            Scanner scanner = new Scanner(new File("small.txt"));

            int og,ng,amount;
            for(int c=0;c<20;c++)
                bank.accounts.add(new Account(c));

            for(int c=0;c<8;c++)
                new Thread(new Worker(c,bank)).start();

            while(scanner.hasNextInt()){
                og = scanner.nextInt();
                ng = scanner.nextInt();
                amount = scanner.nextInt();
                bank.list.add(new Transaction(og,ng,amount));
            }
        }catch(java.io.FileNotFoundException e){}

        System.out.print(bank.toString());
    }

    public String toString(){
        String s="";

        if(this.accounts!=null)
            for(Account a:this.accounts)
                if(a!=null) {
                    s += "acct:" + a.iD + " bal:" + a.balance + " trans:" + a.transactions + "" +
                            "\n";
                }
        return s;
    }
}
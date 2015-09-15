import java.util.concurrent.*;
import java.util.*;
import java.io.File;

public class Bank{
    public ArrayBlockingQueue<Transaction> list;
    public ArrayList<Account> accounts;
    public int numThreads=8;
    public CountDownLatch latch;

    public static void main(String[] args) {
        Bank bank = new Bank(10000);

        try{
            Scanner scanner = new Scanner(new File("5k.txt"));

            int og,ng,amount;
            for(int c=0;c<20;c++)
                bank.accounts.add(new Account(c));

            for(int c=0;c<bank.numThreads;c++)
                new Thread(new Worker(c, bank,bank.latch)).start();

            while(scanner.hasNextInt()){
                og = scanner.nextInt();
                ng = scanner.nextInt();
                amount = scanner.nextInt();
                bank.list.add(new Transaction(og,ng,amount));
            }

            for(int c=0;c<bank.numThreads;c++)
                bank.list.add(new Transaction(-1,0,0));

        }catch(java.io.FileNotFoundException e){}

        try{
            bank.latch.await();
        }catch(InterruptedException e){}

        System.out.print(bank.toString());
    }

    public synchronized Transaction getTrans(){
        Transaction t=null;
        while(t==null) {
            try {
                t = list.take();
            } catch (InterruptedException e) {
            }
        }
        return t;
    }

    public Bank(int transactions){
        list=new ArrayBlockingQueue<Transaction>(transactions);
        accounts=new ArrayList<Account>();
        latch=new CountDownLatch(numThreads);
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
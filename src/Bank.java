import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;
import java.io.File;

public class Bank{
    public ArrayBlockingQueue<Transaction> list;
    public ArrayList<Account> accounts;
    public ArrayList<Worker> threads;
    public int numThreads=8;

    public static void main(String[] args) {
        Bank bank = new Bank(10000);

        try{
            Scanner scanner = new Scanner(new File("small.txt"));

            int og,ng,amount;
            for(int c=0;c<20;c++)
                bank.accounts.add(new Account(c));

            for(int c=0;c<bank.numThreads;c++) {
                bank.threads.add(new Thread(new Worker(c, bank)));
                bank.threads.get(c).run();
            }

            while(scanner.hasNextInt()){
                og = scanner.nextInt();
                ng = scanner.nextInt();
                amount = scanner.nextInt();
                bank.list.add(new Transaction(og,ng,amount));
            }
            for(int c=0;c<bank.numThreads;c++)
                bank.list.add(new Transaction(-1,0,0));
        }catch(java.io.FileNotFoundException e){}

        boolean done=true;
        for(Thread t:bank.threads)
            if((Worker)t.done)
                done=false;
        try {
            if (!done)
                Thread.sleep(1000);
        }catch(InterruptedException e){}

        System.out.print(bank.toString());
    }

    public synchronized Transaction getTrans(){
        Transaction t=new Transaction(0,0,0);
        try{
            t=list.take();
        }catch(InterruptedException e){}
        return t;
    }

    public Bank(int transactions){
        list=new ArrayBlockingQueue<Transaction>(transactions);
        accounts=new ArrayList<Account>();
        threads=new ArrayList<Thread>();
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
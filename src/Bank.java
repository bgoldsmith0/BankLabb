import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;
import java.io.File;

public class Bank{
    public static ArrayBlockingQueue<Transaction> list;
    public static ArrayList<Account> accounts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new File("small.txt"));
        int og,ng,amount;
        for(int c=0;c<20;c++)
            accounts.add(new Account(c));

        for(int c=0;c<8;c++)
            new Thread(new Worker(c)).start();

        while(scanner.hasNextInt()){
            og = scanner.nextInt();
            ng = scanner.nextInt();
            amount = scanner.nextInt();
            list.add(new Transaction(og,ng,amount));
        }
    }
}
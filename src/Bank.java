package com.company;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;
import java.io.File;

public class Bank{
    public static ArrayBlockingQueue<Transaction> list;
    public static

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new File("tall.txt"));
        int og,ng,amount;
        
        while(scanner.hasNextInt()){
            og = scanner.nextInt();
            ng = scanner.nextInt();
            amount = scanner.nextInt();
            list.add(new Transaction(og,ng,amount));
        }
    }
}

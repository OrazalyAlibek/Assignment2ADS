package src;

import java.util.*;

public class BankingSystem {
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactions = new Stack<>();

    public static void addAccount(String username, double balance) {
        accounts.add(new BankAccount(username, balance));
        System.out.println("Account added successfully");
    }

    public static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }
        System.out.println("\nAccounts list:");
        int i = 1;
        for (BankAccount a : accounts) {
            System.out.println(i++ + ". " + a.getUserName() + " - Balance: " + a.getBalance());
        }
    }

    public static BankAccount findByUsername(String username) {
        for (BankAccount a : accounts) {
            if (a.getUserName().equals(username)) {
                return a;
            }
        }
        return null;
    }

    static void deposit(String username, double amount) {
        BankAccount a = findByUsername(username);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }
        a.setBalance(a.getBalance() + amount);
        String transaction = "Deposit " + amount + " to " + username;
        transactions.push(transaction);
        System.out.println("New Balance:  " + a.getBalance());
    }

    static void withdraw(String username, double amount) {
        BankAccount a = findByUsername(username);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }
        a.setBalance(a.getBalance() - amount);
        String transaction = "Withdraw " + amount + " from " + username;
        transactions.push(transaction);
        System.out.println("New Balance:  " + a.getBalance());
    }

    static void showLastTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        System.out.println("Last transaction: " + transactions.peek());
    }
    static void undoLastTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        System.out.println("Undo : " + transactions.pop() + " removed");
    }
    static void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        System.out.println("Transactions list:");
        List<String> list = new ArrayList<>(transactions);
        Collections.sort(list);
        for (String transaction : list) {
            System.out.println(transaction);
        }
    }

    static void main(String[] args) {
        System.out.println("------Task 1------");
        addAccount("Ali", 150000);
        addAccount("Sara", 220000);
        displayAccounts();
        System.out.println(findByUsername("Sara"));

        System.out.println("\n------Task 2------");
        System.out.println("Enter username: Ali ");
        System.out.println("Deposit: 50000 ");
        deposit("Ali", 50000);

        System.out.println("\n------Task 3------");
        displayTransactions();
        showLastTransaction();
        undoLastTransaction();
        showLastTransaction();
    }
}

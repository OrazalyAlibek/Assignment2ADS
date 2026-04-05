package src;

import java.util.*;

public class Tasks {
    static LinkedList<BankAccount> accounts = new LinkedList<>(); //Task 1
    static Stack<String> transactions = new Stack<>(); //Task 3
    static Queue<String> billQueue= new LinkedList<>(); //Task 4
    static Queue<String> accountRequests = new LinkedList<>(); //Task 5
    static BankAccount[] fixedAccounts = new BankAccount[3]; //Task 6

    //Task 1
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

    //Task 2
    public static void deposit(String username, double amount) {
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

    public static void withdraw(String username, double amount) {
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

    //Task 3
    public static void showLastTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        System.out.println("Last transaction: " + transactions.peek());
    }
    public static void undoLastTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        System.out.println("Undo : " + transactions.pop() + " removed");
    }
    public static void displayTransactions() {
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

    //Task 4
    public static void addBill(String bill) {
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    public static void processNextBill() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills found");
            return;
        }
        System.out.println("Processing: " + billQueue.poll());
        if (!billQueue.isEmpty()) {
            System.out.print("Remaining: ");
            for (String b : billQueue) {
                System.out.print(b + " ");
                System.out.println();
            }
        }
        else
            System.out.println("No bills found");
    }

    public static void displayBills() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills found");
            return;
        }
        System.out.println("Bills queue:");
        int i = 1;
        for (String bill : billQueue) {
            System.out.println(i++ + ". " + bill);
        }
    }

    //Task 5
    public static void submitAccountRequest(String username, double initialBalance) {
        accountRequests.add(username + " | " + initialBalance);
        System.out.println("Request submitted: " + username);
    }

    public static void processAccountRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No requests found");
            return;
        }
        String request = accountRequests.poll();
        String[] parts = request.split("\\|");
        String username = parts[0];
        double initialBalance = Double.parseDouble(parts[1]);
        addAccount(username, initialBalance);
        System.out.println("Request approved: " + username);
    }

    public static void displayAccountRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No requests found");
            return;
        }
        System.out.println("Request list:");
        int i = 1;
        for (String request : accountRequests) {
            System.out.println(i++ + ". " + request);
        }
    }

    //Task 6
    public static void fixedArray() {
        fixedAccounts[0] = new BankAccount("Amir",340000);
        fixedAccounts[1] = new BankAccount("Adil",570000);
        fixedAccounts[2] = new BankAccount("Zaura",420000);
    }

    public static void displayFixedArray() {
        System.out.println("Fixed Array:");
        for (int i = 0; i < fixedAccounts.length; i++) {
            System.out.println(i+1 + " : " + fixedAccounts[i]);
        }
    }

    public static void main(String[] args) {
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

        System.out.println("\n------Task 4------");
        addBill("Electricity bill");
        addBill("Internet bill");
        addBill("Water bill");
        displayBills();
        processNextBill();
        processNextBill();

        System.out.println("\n------Task 5------");
        submitAccountRequest("Kanat", 600000);
        submitAccountRequest("Nurlan", 300000);
        displayAccountRequests();
        processAccountRequest();
        displayAccountRequests();
        processAccountRequest();
        displayAccounts();

        System.out.println("\n------Task 6------");
        fixedArray();
        displayFixedArray();
    }
}

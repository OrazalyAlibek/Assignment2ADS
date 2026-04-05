package src;

import java.util.*;

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);

    static void bankMenu() {
        while (true) {
            System.out.println("\nBANK MENU");
            System.out.println("==================");
            System.out.println("1. Open account ");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw ");
            System.out.println("4. View history ");
            System.out.println("5. Undo last transaction ");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            switch (sc.nextLine().trim()) {
                case "1":
                    System.out.print("Username: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Initial balance: ");
                    double initialBalance = sc.nextDouble();
                    sc.nextLine();
                    Tasks.submitAccountRequest(u, initialBalance);
                    break;
                case "2":
                    System.out.print("Username: ");
                    String du = sc.nextLine().trim();
                    System.out.print("Amount: ");
                    double dep = sc.nextDouble();
                    sc.nextLine();
                    Tasks.deposit(du, dep);
                    break;
                case "3":
                    System.out.print("Username: ");
                    String wu = sc.nextLine().trim();
                    System.out.print("Amount: ");
                    double wd = sc.nextDouble();
                    sc.nextLine();
                    Tasks.withdraw(wu, wd);
                    break;
                case "4": Tasks.displayTransactions(); break;
                case "5": Tasks.undoLastTransaction(); break;
                case "0": return;
                default:  System.out.println("Invalid option.");
            }
        }
    }

    // ATM Menu
    static void atmMenu(Scanner sc) {
        System.out.print("\nEnter your username: ");
        String user = sc.nextLine().trim();
        BankAccount acc = Tasks.findByUsername(user);
        if (acc == null) { System.out.println("Account not found."); return; }

        while (true) {
            System.out.println("\nATM MENU");
            System.out.println("1. Balance ");
            System.out.println("2. Withdraw ");
            System.out.println("0. Back ");
            System.out.print("Choice: ");
            switch (sc.nextLine().trim()) {
                case "1":
                    System.out.println("Balance: " + acc.getBalance());
                    break;
                case "2":
                    System.out.print("Amount: ");
                    double wd = sc.nextDouble();
                    sc.nextLine();
                    Tasks.withdraw(user, wd);
                    break;
                case "0": return;
                default:  System.out.println("Invalid option.");
            }
        }
    }

    // Admin Menu
    static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\nADMIN MENU");
            System.out.println("1. View pending requests ");
            System.out.println("2. Process next request ");
            System.out.println("3. View all accounts ");
            System.out.println("4. View bill queue ");
            System.out.println("5. Add bill ");
            System.out.println("6. Process next bill ");
            System.out.println("0. Back ");
            System.out.print("Choice: ");
            switch (sc.nextLine().trim()) {
                case "1": Tasks.displayAccountRequests(); break;
                case "2": Tasks.processAccountRequest(); break;
                case "3": Tasks.displayAccounts(); break;
                case "4": Tasks.displayBills(); break;
                case "5":
                    System.out.print("Bill name: ");
                    Tasks.addBill(sc.nextLine().trim());
                    break;
                case "6": Tasks.processNextBill(); break;
                case "0": return;
                default:  System.out.println("Invalid option.");
            }
        }
    }
// MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tasks.demo();
        System.out.println("==========================");
        System.out.println("WELCOME TO BANK SYSTEM");
        System.out.println("==========================");

        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("1. Enter Bank ");
            System.out.println("2. Enter ATM ");
            System.out.println("3. Admin Area ");
            System.out.println("4. Exit ");
            System.out.print("Choice: ");
            switch (sc.nextLine().trim()) {
                case "1": bankMenu();  break;
                case "2": atmMenu(sc);  break;
                case "3": adminMenu(sc); break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Enter 1-4.");
            }
        }
    }
}
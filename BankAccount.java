public class BankAccount {
    private static int counter = 1;
    private int accountNumber;
    private String userName;
    private double balance;

    public BankAccount(String userName, double balance) {
        this.accountNumber = counter++;
        this.userName = userName;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getUserName() {
        return userName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account # " + accountNumber + " | " + userName + " - Balance: " + balance;
    }
}

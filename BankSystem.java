import java.util.Scanner;
class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;
    public Account(String customerName, String accountNumber, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
    public double getBalance() {
        return balance;
    }
}
class SavAcct extends Account {
    private double interestRate;
    public SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
    public void computeInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
class CurrAcct extends Account {
    private double minimumBalance;
    private double penaltyCharge;
    public CurrAcct(String customerName, String accountNumber, double initialBalance, double minimumBalance, double penaltyCharge) {
        super(customerName, accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
        this.penaltyCharge = penaltyCharge;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    private void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= penaltyCharge;
            System.out.println("Penalty imposed: " + penaltyCharge);
            System.out.println("New Balance after penalty: " + balance);
        }
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank System");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account type (savings/current): ");
        String accountType = scanner.nextLine().toLowerCase();
        Account account;
        if (accountType.equals("savings")) {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter interest rate (%): ");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(name, accountNumber, initialBalance, interestRate);
        } else if (accountType.equals("current")) {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();
            System.out.print("Enter penalty charge: ");
            double penaltyCharge = scanner.nextDouble();
            account = new CurrAcct(name, accountNumber, initialBalance, minimumBalance, penaltyCharge);
        } else {
            System.out.println("Invalid account type!");
            return;
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            System.out.println("3. Withdraw");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute Interest");
            }
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).withdraw(withdrawAmount);
                    } else if (account instanceof CurrAcct) {
                        ((CurrAcct) account).withdraw(withdrawAmount);
                    }
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeInterest();
                    } else {
                        System.out.println("Interest computation is not available for Current Accounts.");
                    }
            }
        }
    }
}

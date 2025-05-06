import java.util.Scanner;

public class BankApp {
    static class Account {
        String name;
        double balance;

        Account(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        void deposit(double amount) {
            balance += amount;
        }

        boolean withdraw(double amount) {
            if (amount > balance) return false;
            balance -= amount;
            return true;
        }

        void display() {
            System.out.println(name + "'s Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.next();
        Account acc = new Account(name, 0);

        while (true) {
            System.out.println("\n1. Deposit 2. Withdraw 3. View Balance 4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Amount to deposit: ");
                double amount = sc.nextDouble();
                acc.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Amount to withdraw: ");
                double amount = sc.nextDouble();
                if (!acc.withdraw(amount)) {
                    System.out.println("Insufficient funds.");
                }
            } else if (choice == 3) {
                acc.display();
            } else {
                break;
            }
        }
        sc.close();
    }
}

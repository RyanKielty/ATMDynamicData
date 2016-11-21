import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ryankielty on 11/16/16.
 */
public class Account {

    private String name;
    private String service;
    private Double balance = null;
    private boolean isCorrectName = true;

    // name - balance

    HashMap<String, Double> account = new HashMap<>();


    public void chooseAccount() {
        account.put("Ryan", 1030.32);
        account.put("Luke", 1332.14);
        account.put("Macbeth", 1234.65);
    }

    //Start
    public void chooseName() throws Exception {
        System.out.println("Welcome City Bank Member!");
        System.out.println("What is your name?");
        System.out.println();

//
        name = ATM.scanner.nextLine();

//HashMap
        balance = account.get(name);

        if(balance == null) {
            isCorrectName = false;
        }

        if (isCorrectName) {
            System.out.println();
            System.out.println("Greetings " + name + ":");
            System.out.println();
            chooseService();
        } else {
            addAccount();
        }
    }

//Add
    public void addAccount() throws Exception {
        System.out.println("\n" + name + " is not a recognized account...\nWould you like to add this account? [y/n]\n");
        String answer = ATM.scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println("Account added for " + name + "\n");
            chooseService();
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("Transaction Canceled\n");
            chooseName();
        }
    }

//Remove
    public void removeAccount() throws Exception {
        System.out.println("\nWould you like to remove this account? [y/n]\n");
        String answer = ATM.scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            balance = account.remove(name);
            System.out.println("Account removed for " + name + "\n");
            chooseName();
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("Transaction Canceled\n");
            chooseName();
        }
    }

//Menu
    public void chooseService() throws Exception {
        System.out.println("Please select a transaction " + name);
        System.out.println("\n1 > Account Balance\n2 > Withdrawal\n3 > Remove Account\n4 > Cancel Transaction\n");
        service = ATM.scanner.nextLine();
        if (service.equalsIgnoreCase("1")) {
            System.out.println("\n1 > Account Balance: $ " + balance + "\n");
        } else if (service.equalsIgnoreCase("2")) {
            System.out.println("\n2 > Withdrawal:\nHow much would you like to withdrawal?\n");
            chooseAccountWithdrawal();
        } else if (service.equalsIgnoreCase("3")) {
            removeAccount();
        } else if (service.equalsIgnoreCase("4")) {
            System.out.println("4 > Transaction Canceled\n\nThank you for choosing City Bank, and until next time!\n");
            chooseName();
        } else {
            System.out.println("Invalid Selection");
            chooseService();
        }
    }

//2 > Withdrawal
    public void chooseAccountWithdrawal() throws Exception {
        Double withdrawalAmount = Double.parseDouble(ATM.scanner.nextLine());
        if (balance >= withdrawalAmount) {
            System.out.println("\nRemaining Account Balance : $" + (balance-withdrawalAmount) + "\nPlease collect your funds.\n\nThank you for choosing City Bank!\n");
            chooseService();
        } else {
            System.out.println("**INSUFFICIENT FUNDS**\n");
            chooseAccountWithdrawal();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}

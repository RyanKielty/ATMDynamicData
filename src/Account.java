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
        account.put("Eric", 1332.14);
        account.put("Macbeth", 1234.65);
        account.put("Jimbo", 1575.84);
    }

    //Starting point
    public void chooseName() throws Exception {
        System.out.println("Welcome City Bank Member!");
        System.out.println("What is your name?");
        System.out.println();

    //
        name = ATM.scanner.nextLine();

    //Balance associated with account name
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





    public void addAccount() throws Exception {
        System.out.println();
        System.out.println(name + " is not a recognized account...");
        System.out.println("Would you like to add this account?");
        System.out.println("[y/n]");
        System.out.println();
        String answer = ATM.scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println();
            System.out.println("Account added for " + name);
            System.out.println();
            chooseService();
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("Transaction Canceled");
            chooseName();
        }
    }





    public void chooseService() throws Exception {
        System.out.println("Please select a transaction " + name);
        System.out.println();
        System.out.println("1 > Account Balance");
        System.out.println("2 > Withdrawal");
        System.out.println("3 > Cancel Transaction");
        System.out.println();
        service = ATM.scanner.nextLine();
        if (service.equalsIgnoreCase("1")) {
            System.out.println();
            System.out.println("Account Balance: $ " + balance);
            System.out.println();
        } else if (service.equalsIgnoreCase("2")) {
            System.out.println();
            System.out.println("Withdrawal:");
            System.out.println();
            chooseAccountWithdrawal();
        } else if (service.equalsIgnoreCase("3")) {
            System.out.println();
            System.out.println("Thank you for choosing City Bank, and until next time!");
            System.out.println();
            System.out.println();
            chooseName();
        } else {
            System.out.println("Invalid Selection");
            chooseService();
        }
    }



//2 > Withdrawal

    public void chooseAccountWithdrawal() throws Exception {
        System.out.println("How much would you like to withdrawal?");
        System.out.println("");
        Double withdrawalAmount = ATM.scanner.nextDouble();
        if (balance >= withdrawalAmount) {
            System.out.println("");
            System.out.println("Remaining Account Balance : $" + (balance-withdrawalAmount));
            System.out.println("");
            System.out.println("Please collect your funds.");
            System.out.println("Thank you for choosing City Bank!");
            System.out.println(" ");
            System.out.println(" ");
        } else {
            System.out.println("**INSUFFICIENT FUNDS**");
            System.out.println("");
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

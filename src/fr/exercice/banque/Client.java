package fr.exercice.banque;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Client {

    public Account[] clientAccounts = new Account[100];
    private final int clientNumber = ThreadLocalRandom.current().nextInt(0, 100000000 + 1);
    private int nbrOfAccounts = 0;
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public int getClientNumber() {
        return this.clientNumber;
    }

    public String getName() {
        return this.name;
    }

    public void addAccount(){
        this.clientAccounts[this.nbrOfAccounts] = new Account(1000, false);
        this.nbrOfAccounts++;
    }

    public int nbrOfAccounts() {
        return this.nbrOfAccounts;
    }

    public float getTotalBalance() {
        float totalBalance = 0;
        for(Account account : this.clientAccounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void setMainAccount(){
        boolean hasMainAccount = false;
        for(Account account : this.clientAccounts) {
            if (account.getIsMainAccount()) {
                hasMainAccount = true;
                break;
            }
        }

        if (hasMainAccount) {
            System.out.println("The client already has a main account");
        }
    }

    public void replenish() {

    }
}

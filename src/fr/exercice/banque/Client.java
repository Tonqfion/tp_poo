package fr.exercice.banque;

import java.util.concurrent.ThreadLocalRandom;

public class Client {

    public Account[] clientAccounts = new Account[100];
    private int clientNumber = ThreadLocalRandom.current().nextInt(0, 100000000 + 1);
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
        this.clientAccounts[this.nbrOfAccounts] = new Account();
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
}

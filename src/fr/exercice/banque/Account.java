package fr.exercice.banque;

import java.util.concurrent.ThreadLocalRandom;

public class Account {
    private final int accountNumber = ThreadLocalRandom.current().nextInt(0, 100000000 + 1);

    private float balance;

    public void deposit(float amount) {
        this.balance += amount;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void withdrawal(float amount) {
        this.balance -= amount;
    }

    public float getBalance() {
        return this.balance;
    }

    public void showBalance() {
        System.out.println("Your bank account balance is : " + this.balance);
    }

    public void transferMoney(float amount, Account recipient) {
        this.balance -= amount;
        recipient.balance += amount;
    }
}

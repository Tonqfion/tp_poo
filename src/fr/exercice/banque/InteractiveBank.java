package fr.exercice.banque;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class InteractiveBank {
    private Client[] clients = new Client[100];
    private int nbrOfClients = 0;

    public void addClient(String clientName) {
        this.clients[nbrOfClients] = new Client(clientName);
        this.nbrOfClients++;
    }

    public void getClientBalance(int clientNumber) {
        Client foundClient = Arrays.stream(this.clients).filter(client -> client.getClientNumber() == clientNumber).findFirst().orElse(null);
        assert foundClient != null;
        System.out.println("The balance of client " + foundClient.getName() + " is " + foundClient.getTotalBalance() + " dollars");
    }

    public void getCompleteBankBalance() {
        float bankBalance = 0;
        for (Client client : this.clients) {
            bankBalance += client.getTotalBalance();
        }
        System.out.println("The complete bank balance is " + bankBalance + " dollars.");
    }

    public void interact() {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do? \n1) Add a client \n2) Complete an operation for a client\n3) Show the bank report");
        String choice = input.next();
        if (Objects.equals(choice, "-1")) {
            this.interactAddClient(input);
        } else if (Objects.equals(choice, "-2")) {
            this.interactWithClient(input);
        } else if (Objects.equals(choice, "-3")) {

        }
    }

    private void interactAddClient(Scanner input) {
        System.out.println("Type the name of the client");
        String clientName = input.next();
        this.addClient(clientName);
    }

    private void interactWithClient(Scanner input) {
        System.out.println("Choose the client : ");
        int index = 1;
        for (Client client : this.clients) {
            System.out.println(index + ") " + client.getName());
        }
        String clientIndexBeforeParse = input.next();
        Client chosenClient = this.clients[choiceIndex(clientIndexBeforeParse)];
        System.out.println("Choose the operation : \n1) Show balance\n2) Make withdrawal\n3) Make deposit\n4) Transfer Money");
        String chooseOperation = input.next();

        if (Objects.equals(chooseOperation, "-1")) {
            System.out.println(chosenClient.getTotalBalance());

        } else if (Objects.equals(chooseOperation, "-2")) {

            Account chosenAccount = this.clientOperationInit(chosenClient, input);
            System.out.println("How much do you want to deposit?");
            chosenAccount.deposit(input.nextFloat());


        } else if (Objects.equals(chooseOperation, "-3")) {

            Account chosenAccount = this.clientOperationInit(chosenClient, input);
            System.out.println("How much do you want to withdraw?");
            chosenAccount.withdrawal(input.nextFloat());

        } else if (Objects.equals(chooseOperation, "-4")) {
            //TODO : Refactorisé ce qu'il y a plus haut
        }
    }

    private Account clientOperationInit(Client chosenClient, Scanner input) {
        StringBuilder promptString = new StringBuilder("Which client account?");
        int index = 1;
        for(Account account : chosenClient.clientAccounts) {
            promptString.append(index).append(") ").append(account.getAccountNumber()).append("\n");
            index++;
        }
        System.out.println(promptString);
        String accountIndexBeforeParse = input.next();
        return chosenClient.clientAccounts[this.choiceIndex(accountIndexBeforeParse)];
    }

    private int choiceIndex(String input) {
        return Integer.parseInt(input.replace("-", "")) - 1;
    }
}

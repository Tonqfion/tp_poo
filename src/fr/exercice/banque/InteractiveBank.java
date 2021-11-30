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
        System.out.println("What would you like to do ? \n1) Add a client \n2) Complete an operation for a client\n3) Show the bank report");
        String choice = input.next();
        if (Objects.equals(choice, "- 1")) {
            this.interactAddClient(input);
        } else if (Objects.equals(choice, "- 2")) {

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
        for(Client client : this.clients) {
            System.out.println(index + ") " + client.getName());
        }
        String clientIndexBeforeParse = input.next();
        int clientIndexAfterParse = Integer.parseInt(clientIndexBeforeParse.replaceAll("[- ]",""));
        Client chosenClient = this.clients[clientIndexAfterParse -1];
        System.out.println("Choose the operation : \n1) Show balance\n2) Make withdrawal\n3) Make deposit\n4) Transfer Money");
        String chooseOperation = input.next();
        if (Objects.equals(chooseOperation, "-1")) {

        } else if (Objects.equals(chooseOperation, "-2")) {

        }

    }
}

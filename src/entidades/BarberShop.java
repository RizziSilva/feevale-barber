package entidades;

import java.util.*;
import java.util.ArrayList;

public class BarberShop {
    private int availableStandPlaces;
    private Couch couch;
    private CreditManchine creditManchine;
    private Barber barberOne;
    private Barber barberTwo;
    private Barber barberThree;
    private List<Client> clients = Collections.synchronizedList(new ArrayList<>());

    public BarberShop() {
        this.availableStandPlaces = 16;
        this.couch = new Couch();
        this.creditManchine = new CreditManchine();
        this.barberOne = new Barber("William", clients);
        this.barberTwo = new Barber("Rafael", clients);
        this.barberThree = new Barber("Some Other Dude", clients);

        barberOne.start();
        barberTwo.start();
        barberThree.start();
    }

    public void attendClient() {
//        Barber clerk = this.barbers.get(0);
//        client.getHairCut(clerk);
//        clerk.clientPayment(client);
    }


    public void receiveNewClient(Client client) {
        if (!this.couch.isFull() && false) {
            this.couch.getClients().add(client);
        } else if (hasStandingPlaces()) {
            this.clients.add(client);
        } else {
            System.out.println("Barbearia cheia, cliente vai embora.");
        }
    }

    private boolean hasStandingPlaces() {
        return this.availableStandPlaces > this.clients.size();
    }

    public Couch getCouch() {
        return couch;
    }

    public CreditManchine getCreditManchine() {
        return creditManchine;
    }

    public int getAvailableStandPlaces() {
        return availableStandPlaces;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Estado atual da barbearia: " +
                "Espaços disponíveis em pé = " + this.availableStandPlaces + "\n" +
                "Espaços disponíveis sentado = " + this.couch.getNumberOfFreeSpaces() + "\n" +
                "Situação da máquina de cartão = " + this.creditManchine.toString();
    }
}

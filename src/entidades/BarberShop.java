package entidades;

import java.util.ArrayList;
import java.util.Collections;

public class BarberShop {
    private int availableStandPlaces;
    private Couch couch;
    private CreditManchine creditManchine;
    private Barber barberOne;
    private Barber barberTwo;
    private Barber barberThree;
    private ArrayList<Barber> barbers = new ArrayList<>();
    private ArrayList<Client> clients = Collections.sync(new ArrayList<Client>());

    public BarberShop() {
        this.availableStandPlaces = 16;
        this.couch = new Couch();
        this.creditManchine = new CreditManchine();
        this.barberOne = new Barber("William", clients);
        this.barberTwo = new Barber("Rafael", clients);
        this.barberThree = new Barber("Some Other Dude", clients);

//        this.barbers.add(barberOne);
//        this.barbers.add(barberTwo);
//        this.barbers.add(barberThree);

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

    public ArrayList<Barber> getBarbers() {
        return barbers;
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

    public ArrayList<Client> getClients() {
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

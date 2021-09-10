package entidades;

import java.util.ArrayList;

public class BarberShop {
    private int availableStandPlaces;
    private Couch couch;
    private CreditManchine creditManchine;
    private ArrayList<Barber> barbers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public BarberShop() {
        this.availableStandPlaces = 16;
        this.couch = new Couch();
        this.creditManchine = new CreditManchine();
        Barber barberOne = new Barber("William");
        Barber barberTwo = new Barber("Rafael");
        Barber barberThree = new Barber("Some Other Dude");

        barberOne.start();
        barberTwo.start();
        barberThree.start();

        this.barbers.add(barberOne);
        this.barbers.add(barberTwo);
        this.barbers.add(barberThree);
    }

    public void receiveNewClient(Client client) {
        this.clients.add(client);
        this.getBarbers().get(0).attendClient(client);
    }

    public void attendClient() {

    }

    public ArrayList<Client> getClients() {
        return clients;
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

    @Override
    public String toString() {
        return "Estado atual da barbearia: " +
                "Espaços disponíveis em pé = " + this.availableStandPlaces + "\n" +
                "Espaços disponíveis sentado = " + this.couch.getNumberOfFreeSpaces() + "\n" +
                "Situação da máquina de cartão = " + this.creditManchine.toString();
    }
}

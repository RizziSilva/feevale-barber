package entidades;

import java.util.ArrayList;

public class WaitingRoom {
    private static final int MAXIMUM_STANDING_PLACES = 16;

    private Couch couch;
    private ArrayList<Client> standingClients = new ArrayList<>();

    public WaitingRoom() {
        this.couch = new Couch();
    }

    public void receiveNewClient(Client client) {
        if (!this.couch.isFull()) {
//            System.out.println("Adicionando cliente no sofá, quando estava vazio " + this.couch.getClients().size());
            this.couch.getClients().add(client);
//            System.out.println("Cliente " + client.getClientName());
        } else if (hasStandingPlaces()) {
//            System.out.println("Não tem espaço no sofá, fica em pé");
            this.standingClients.add(client);
//            System.out.println("Cliente " + client.getClientName());
        } else {
            System.out.println("Barbearia cheia, cliente vai embora.");
        }
    }

    public Client getClientToAttend() {
        boolean hasCouchClients = !this.couch.getClients().isEmpty();
        if (hasCouchClients) {
//            System.out.println("Pega cliente do sofá " + this.couch.getClients().size());
            Client clientToAttend = this.couch.getClients().remove(0);
//            System.out.println("Cliente " + clientToAttend.getClientName());
            putStandingClientIntoCouch();

            return clientToAttend;
        }

        return null;
    }

    private void putStandingClientIntoCouch() {
        boolean hasStandingClient = !this.standingClients.isEmpty();
        if (hasStandingClient) {
//            System.out.println("Coloca cliente que estava em pé no sofá " + this.couch.getClients().size());
            Client client = this.standingClients.remove(0);
//            System.out.println("Cliente indo pro sofá " + client.getClientName());
            this.couch.getClients().add(client);
        }
    }

    private boolean hasStandingPlaces() {
        return standingClients.size() < MAXIMUM_STANDING_PLACES;
    }

    public int getCouchNumber() {
        return this.couch.getClients().size();
    }

    public int getStandingClientsNumber() {
        return this.standingClients.size();
    }
}

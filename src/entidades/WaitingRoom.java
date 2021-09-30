package entidades;

import java.util.ArrayList;

public class WaitingRoom {
    private static final int MAXIMUM_STANDING_PLACES = 16;

    private final Couch couch;
    private final ArrayList<Client> standingClients = new ArrayList<>();

    public WaitingRoom() {
        this.couch = new Couch();
    }

    public void receiveNewClient(Client client) {
        if (!this.couch.isFull()) {
            this.couch.getClients().add(client);
        } else if (hasStandingPlaces()) {
            this.standingClients.add(client);
        } else {
            System.out.println("Barbearia cheia, cliente vai embora.");
        }
    }

    public Client getClientToAttend() {
        boolean hasCouchClients = !this.couch.getClients().isEmpty();
        if (hasCouchClients) {
            Client clientToAttend = this.couch.getClients().remove(0);
            putStandingClientIntoCouch();

            return clientToAttend;
        }

        return null;
    }

    private void putStandingClientIntoCouch() {
        boolean hasStandingClient = !this.standingClients.isEmpty();
        if (hasStandingClient) {
            Client client = this.standingClients.remove(0);
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

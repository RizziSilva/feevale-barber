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
            this.couch.getClients().add(client);
        } else if (hasStandingPlaces()) {
            this.standingClients.add(client);
        } else {
            System.out.println("Barbearia cheia, cliente vai embora.");
        }
    }

    public Client getClientToAttend() {
        if (!this.couch.getClients().isEmpty()) {
            Client clientToAttend = this.couch.getClients().remove(0);
            Client standingClientToCouch = this.standingClients.remove(0);
            this.couch.getClients().add(standingClientToCouch);

            return clientToAttend;
        }

        return null;
    }

    private boolean hasStandingPlaces() {
        return standingClients.size() >= MAXIMUM_STANDING_PLACES;
    }
}

package entidades;

import java.util.ArrayList;

public class Couch {
    private static final int MAXIMUM_COUCH_CLIENTS = 4;
    private final ArrayList<Client> clients = new ArrayList<>();

    public Couch() {
    }

    public boolean isFull() {
        return this.clients.size() == MAXIMUM_COUCH_CLIENTS;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}

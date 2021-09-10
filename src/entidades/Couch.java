package entidades;

import java.util.ArrayList;

public class Couch {

    private int totalPlaces = 4;
    private ArrayList<Client> clients = new ArrayList<>();

    public Couch() {}

    public int getNumberOfFreeSpaces() {
        return this.totalPlaces - clients.size();
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }
}

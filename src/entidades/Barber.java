package entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Barber extends Thread {

    private String barberName = "";
    private Client client;
    private final ArrayList<Client> clients;
    private boolean finished = false;

    public Barber(String barberName, ArrayList<Client> clients) {
        super(barberName);
        this.barberName = barberName;
        this.clients = clients;
    }

    @Override
    public void run() {
        while (true) {
            if (clients.size() > 0) {
                synchronized (clients) {
                    Client clientToAttend = clients.get(0);
                    clientToAttend.setBarber(this);
                    this.client = clientToAttend;
                    clientPayment();
                    clients.remove(clientToAttend);
                }
            } else sleep();
        }
    }

    public void clientPayment() {
        System.out.println("Barbeiro " + this.getBarberName() + " inicio o pagamento de " + this.client.getClientName());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.getBarberName() + " interrompido em sua função.");
        }

        System.out.println("Barbeiro " + this.getBarberName() + " terminou o pagamento de " + this.client.getClientName());
        this.client = null;
    }

    public void sleep() {
        System.out.println("Barbeiro " + this.getBarberName() + " irá começar a dormir.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.getBarberName() + " interrompido em sua cestiada.");
        }

        System.out.println("Barbeiro " + this.getBarberName() + " acordou.");
    }

    public boolean isAttendingClient() {
        return Objects.nonNull(this.client);
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }
}

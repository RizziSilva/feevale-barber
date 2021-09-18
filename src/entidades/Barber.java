package entidades;

import java.util.*;
import java.util.ArrayList;
import java.util.Objects;

public class Barber extends Thread {

    private final List<Client> clients;
    private String barberName = "";
    private Client client;
    private boolean finished = false;

    public Barber(String barberName, List<Client> clients) {
        super(barberName);
        this.barberName = barberName;
        this.clients = clients;
    }

    @Override
    public void run() {
        while (true) {
            Client clientToAttend = getClientToAttend();
            if (Objects.nonNull(clientToAttend)) {
                synchronized (this) {
                    clientToAttend.setBarber(this);
                    clientToAttend.start();
                    try {
                        this.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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

    private Client getClientToAttend() {
        synchronized (clients) {
            if (clients.size() > 0) {
                Client client = clients.get(0);
                clients.remove(client);

                return client;
            } else return null;
        }
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

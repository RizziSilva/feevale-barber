package entidades;

import java.util.Objects;

public class Barber extends Thread {

    private String barberName = "";
    private Client client;

    public Barber(String barberName) {
        super(barberName);
        this.barberName = barberName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.getBarberName() + " interrompido em sua função.");
        }
    }

    public void attendClient(Client client) {
        this.client = client;
        System.out.println("Barbeiro " + this.getBarberName() + " iniciou o atendimento de " + this.client.getClientName());

        try {
            this.join();
        } catch (InterruptedException e) {
            // Mata o erro para não interromper o funcionamento.
        }

        System.out.println("Barbeiro " + this.getBarberName() + " terminou o atendimento de " + this.client.getClientName());

        this.clientPayment();
        this.client = null;
    }

    public void clientPayment() {
        System.out.println("Barbeiro " + this.getBarberName() + " inicio o pagamento de " + this.client.getClientName());

        try {
            this.join();
        } catch (InterruptedException e) {
            // Mata o erro para não interromper o funcionamento.
        }

        System.out.println("Barbeiro " + this.getBarberName() + " terminou o pagamento de " + this.client.getClientName());
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

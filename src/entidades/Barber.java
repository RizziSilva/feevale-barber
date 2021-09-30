package entidades;

import java.util.List;
import java.util.Objects;

public class Barber extends Thread {

    private final CreditManchine creditManchine;
    private final Couch couch;
    private String barberName = "";
    private Client client;
    private boolean isPayed = false;


    public Barber(String barberName, CreditManchine creditManchine, Couch couch) {
        super(barberName);
        this.barberName = barberName;
        this.creditManchine = creditManchine;
        this.couch = couch;
    }

    @Override
    public void run() {
        while (true) {
            Client clientToAttend = getClientToAttend();
            if (Objects.nonNull(clientToAttend)) {
                synchronized (this) {
                    this.client = clientToAttend;
                    clientToAttend.setBarber(this);
                    clientToAttend.start();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setPayed(false);
                    tryToBePaid();
                }
            } else sleep();
        }
    }

    public void getPayment() {
        System.out.println("Barbeiro " + this.barberName + " inicio o pagamento de " + this.getClient().getClientName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.barberName + " interrompido no pagamento.");
        }

        System.out.println("Barbeiro " + this.barberName + " terminou o pagamento de " + this.getClient().getClientName());
    }

    public void sleep() {
        System.out.println("Barbeiro " + this.getBarberName() + " irá começar a dormir.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.getBarberName() + " interrompido em sua cestiada.");
        }

        System.out.println("Barbeiro " + this.getBarberName() + " acordou.");
    }

    public void tryToBePaid() {
        while (!this.isPayed) {
            synchronized (this.creditManchine) {
                boolean isCreditManchineOccupied = getCreditManchineIsOccupied();

                if (!isCreditManchineOccupied) {
                    this.creditManchine.setBarberUsing(this);
                    getPayment();
                    this.creditManchine.notify();
                    this.setPayed(true);
                    this.client = null;
                }
            }
        }
    }

    private boolean getCreditManchineIsOccupied() {
        return this.creditManchine.getIsOccupied();
    }

    private Client getClientToAttend() {
        synchronized (this.couch) {
            return
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

    public Client getClient() {
        return client;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}

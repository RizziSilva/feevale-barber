package entidades;

import java.util.Objects;

public class Barber extends Thread {

    private final CreditManchine creditManchine;
    private final WaitingRoom waitingRoom;
    private String barberName = "";
    private Client client;
    private boolean isPayed = false;
    private boolean isBeingPayed = false;
    private boolean isWaitingCreditMachine = false;


    public Barber(String barberName, CreditManchine creditManchine, WaitingRoom waitingRoom) {
        super(barberName);
        this.barberName = barberName;
        this.creditManchine = creditManchine;
        this.waitingRoom = waitingRoom;
    }

    @Override
    public void run() {
        while (true) {
            this.isBeingPayed = false;
            this.isWaitingCreditMachine = false;
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

                    this.isWaitingCreditMachine = true;
                    this.setPayed(false);
                    tryToBePaid();
                }
            } else sleep();
        }
    }

    public String getAction() {
        if (Objects.nonNull(this.client)) {
            if (!this.isBeingPayed && !this.isWaitingCreditMachine) {
                return "Cortando Cabelo de " + this.client.getClientName();
            }

            if (this.isWaitingCreditMachine) {
                return "Esperando para receber pagamento de " + this.client.getClientName();
            }

            return "Recebendo Pagamento de " + this.client.getClientName();
        } else return "Dormindo.";
    }

    private Client getClientToAttend() {
        synchronized (this.waitingRoom) {
            return this.waitingRoom.getClientToAttend();
        }
    }

    private void tryToBePaid() {
        synchronized (creditManchine) {
            this.isBeingPayed = true;
            this.isWaitingCreditMachine = false;
            creditManchine.getPayment();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Barbeiro " + this.getBarberName() + " interrompido em sua cestiada.");
        }
    }

    public String getBarberName() {
        return barberName;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}

package entidades;

import java.util.Objects;

public class Client extends Thread {

    private String clientName = "";
    private Barber barber;

    public Client(String clientName) {
        super(clientName);
        this.clientName = clientName;
    }

    @Override
    public void run() {
        while (true) {
            if (Objects.nonNull(this.barber)) {
                synchronized (this.barber) {
                    getHairCut();
                    this.barber.notify();
                    this.barber = null;
                }
            } else waitToTryAgain();
        }
    }

    public void getHairCut() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Cliente " + this.getClientName() + " foi interrompido no corte.");
        }
    }

    public void waitToTryAgain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Cliente " + this.getClientName() + " foi interrompido no corte.");
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }
}

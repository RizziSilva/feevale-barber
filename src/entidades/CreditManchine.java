package entidades;

import java.util.Objects;

public class CreditManchine extends Thread {
    private Barber barberUsing;
    private boolean isOccupied = false;

    public CreditManchine(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (Objects.nonNull(this.barberUsing)) {
                System.out.println("Será Usada");
                synchronized (this) {
                    this.setOccupied(true);
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setBarberUsing(null);
                    this.setOccupied(false);
                }
            }
        }
    }

    public void setBarberUsing(Barber barberUsing) {
        this.barberUsing = barberUsing;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

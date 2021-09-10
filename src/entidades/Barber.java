package entidades;

public class Barber extends Thread {

    private String name = "";

    public Barber(String barberName) {
        super(barberName);
    }
}

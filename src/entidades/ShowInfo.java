package entidades;

public class ShowInfo extends Thread {

    private final BarberShop barberShop;

    public ShowInfo(BarberShop barberShop) {
        super("Show Info");
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.barberShop.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}

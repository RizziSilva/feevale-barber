package entidades;

import java.util.ArrayList;

public class BarberShop {
    private int standPlaces;
    private Couch couch;
    private CreditManchine creditManchine;
    private ArrayList<Barber> barbers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public BarberShop() {
        this.standPlaces = 16;
        this.couch = new Couch();
        this.creditManchine = new CreditManchine();
        Barber barberOne = new Barber("William");
        Barber barberTwo = new Barber("Rafael");
        Barber barberThree = new Barber("Some Other Dude");

        this.barbers.add(barberOne);
        this.barbers.add(barberTwo);
        this.barbers.add(barberThree);
    }
}

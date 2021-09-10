import entidades.BarberShop;
import entidades.Client;

public class Start {

    public static void main(String[] args) {

        BarberShop barberShop = new BarberShop();
        Client client = new Client("Cliente 1");

        barberShop.receiveNewClient(client);
    }
}

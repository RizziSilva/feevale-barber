import entidades.BarberShop;
import entidades.Client;
import entidades.ClientGenerator;

public class Start {

    public static void main(String[] args) {

        final int NUMBER_OF_CLIENTS = 6;

        BarberShop barberShop = new BarberShop();
        ClientGenerator clientGenerator = new ClientGenerator(barberShop, NUMBER_OF_CLIENTS);
        clientGenerator.addClients();
    }
}

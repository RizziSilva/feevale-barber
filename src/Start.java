import entidades.BarberShop;
import entidades.Client;
import entidades.ClientGenerator;

public class Start {

    public static void main(String[] args) {

        final int NUMBER_OF_CLIENTS = 10;

        BarberShop barberShop = new BarberShop();
        Client client = new Client("Cliente teste");
        barberShop.getClients().add(client);
        ClientGenerator clientGenerator = new ClientGenerator(barberShop, NUMBER_OF_CLIENTS);
    }
}

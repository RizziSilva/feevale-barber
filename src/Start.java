import entidades.BarberShop;
import entidades.ClientGenerator;
import entidades.ShowInfo;

public class Start {

    public static void main(String[] args) {

        final int NUMBER_OF_CLIENTS = 30;

        BarberShop barberShop = new BarberShop();
        ShowInfo showInfo = new ShowInfo(barberShop);
        showInfo.start();
        ClientGenerator clientGenerator = new ClientGenerator(barberShop, NUMBER_OF_CLIENTS);
        clientGenerator.addClients();
    }
}

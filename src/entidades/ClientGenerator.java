package entidades;

import java.util.concurrent.TimeUnit;

public class ClientGenerator {
    public BarberShop barberShop;
    public int numberToGenerate = 10;

    public ClientGenerator(BarberShop barberShop, int numberToGenerate) {
        this.barberShop = barberShop;
        this.numberToGenerate = numberToGenerate;
    }

    public void addClients() {
        int clientQuantity = 0;
        while (clientQuantity < this.numberToGenerate) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String clientName = "Cliente " + ++clientQuantity;
            Client newClient = new Client(clientName);
            barberShop.receiveNewClient(newClient);
        }
    }
}

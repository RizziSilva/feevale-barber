package entidades;

import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ClientGenerator {
    public BarberShop barberShop;
    Random gerador = new Random();
    public int numberToGenerate = 10;

    public ClientGenerator(BarberShop barberShop, int numberToGenerate) {
        this.barberShop = barberShop;
        this.numberToGenerate = numberToGenerate;
    }

    public void addClients() {
        int clientQuantity = 0;
        while (true) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int numero = gerador.nextInt((4));
            if(numero == 3){
                String clientName = "Cliente " + ++clientQuantity;
                Client newClient = new Client(clientName);

                barberShop.receiveNewClient(newClient);
            }

        }
    }
}

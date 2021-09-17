package entidades;

public class ClientGenerator extends Thread {
    public BarberShop barberShop;
    public int numberToGenerate = 10;

    public ClientGenerator(BarberShop barberShop, int numberToGenerate) {
        this.barberShop = barberShop;
        this.numberToGenerate = numberToGenerate;
    }

    @Override
    public void run() {
        int clientQuantity = 0;
        while (clientQuantity < this.numberToGenerate) {

            Client newClient = new Client("Cliente " + ++clientQuantity);
            barberShop.receiveNewClient(newClient);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Erro ao criar o cliente");
            }
        }
    }
}

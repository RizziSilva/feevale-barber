package entidades;

import java.util.concurrent.TimeUnit;

public class BarberShop {
    private WaitingRoom waitingRoom;
    private CreditManchine creditManchine;
    private Barber barberOne;
    private Barber barberTwo;
    private Barber barberThree;

    public BarberShop() {
        this.waitingRoom = new WaitingRoom();
        this.creditManchine = new CreditManchine("Máquina Cartão");
        this.barberOne = new Barber("William", creditManchine, waitingRoom);
        this.barberTwo = new Barber("Rafael", creditManchine, waitingRoom);
        this.barberThree = new Barber("Some Other Dude", creditManchine, waitingRoom);

        barberOne.start();
        barberTwo.start();
        barberThree.start();
        creditManchine.start();
    }

    public void receiveNewClient(Client client) {
        this.waitingRoom.receiveNewClient(client);
    }

    public void showInfos() {
        while (true) {
            System.out.println(this.toString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Estado Atual : " + "\n" +
                "Clientes Sentados: " + this.waitingRoom.getCouchNumber() + "\n" +
                "Clientes em Pé: " + this.waitingRoom.getStandingClientsNumber() + "\n" +
                "Barbeiro " + this.barberOne.getBarberName() + " está: " + this.barberOne.getAction() + "\n" +
                "Barbeiro " + this.barberTwo.getBarberName() + " está: " + this.barberOne.getAction() + "\n" +
                "Barbeiro " + this.barberThree.getBarberName() + " está: " + this.barberOne.getAction() + "\n" +
                "========================================================================================" + "\n";
    }
}

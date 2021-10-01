package entidades;

public class BarberShop {
    private final WaitingRoom waitingRoom;
    private final CreditManchine creditManchine;
    private final Barber barberOne;
    private final Barber barberTwo;
    private final Barber barberThree;

    public BarberShop() {
        this.waitingRoom = new WaitingRoom();
        this.creditManchine = new CreditManchine();
        this.barberOne = new Barber("William", creditManchine, waitingRoom);
        this.barberTwo = new Barber("Rafael", creditManchine, waitingRoom);
        this.barberThree = new Barber("Some Other Dude", creditManchine, waitingRoom);

        barberOne.start();
        barberTwo.start();
        barberThree.start();
    }

    public void receiveNewClient(Client client) {
        this.waitingRoom.receiveNewClient(client);
    }

    @Override
    public String toString() {
        return "Estado Atual : " + "\n" +
                "Clientes Sentados: " + this.waitingRoom.getCouchNumber() + "\n" +
                "Clientes em Pé: " + this.waitingRoom.getStandingClientsNumber() + "\n" +
                "Barbeiro " + this.barberOne.getBarberName() + " está: " + this.barberOne.getAction() + "\n" +
                "Barbeiro " + this.barberTwo.getBarberName() + " está: " + this.barberTwo.getAction() + "\n" +
                "Barbeiro " + this.barberThree.getBarberName() + " está: " + this.barberThree.getAction() + "\n" +
                "========================================================================================" + "\n";
    }
}

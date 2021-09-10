package entidades;

public class Client extends Thread {

    private String clientName = "";

    public Client(String clientName) {
        super(clientName);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

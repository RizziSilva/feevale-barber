package entidades;

public class CreditManchine {

    private boolean isOccupied = false;
    private String persongUsing = "";

    public CreditManchine() {}

    public String getPersongUsing() {
        return persongUsing;
    }

    public void setPersongUsing(String persongUsing) {
        this.persongUsing = persongUsing;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}
package edu.gatech.mdiamond8.partytrack.model.user;

import edu.gatech.mdiamond8.partytrack.model.Drink;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a part attendee
 *
 * Author Jordan Goldstein
 */
public class Attendee extends User{
    private String ID;
    private String QRCode;
    private int drinksHad;
    private double ouncesAHad;
    private List<Drink> drinksHadList = new ArrayList<>();


    /**
     * Default Attendee Constructor
     */
    public Attendee() {
        ID = "123456789";
        QRCode = "";
        type = Types.Attendee;
        drinksHad = 0;
        ouncesAHad = 0;
    }

    /**
     * Custom Attendee Constructor
     * @param ID the Gatech ID of the Attendee
     * @param QRCode the Assigned QRCode of the Attendee
     */
    public Attendee(String ID, String QRCode) {
        this.QRCode = QRCode;
        this.ID = ID;
        type = Types.Attendee;
        drinksHad = 0;
        ouncesAHad = 0;
    }

    public void giveDrink(Drink drink) {
        drinksHad++;
        ouncesAHad += drink.getAAmount();
        drinksHadList.add(drink);
    }
    /**
     * Determines whether a person has exceeed the party drink limit
     * @param limit the party's drink limit
     * @return whether they've exceeded the limit
     */
    public boolean canDrink(int limit) {
        return limit > drinksHad;
    }

    /**
     * Returns the ounces of alcohol had
     * @return ounces of alcohol had
     */
    public double getOuncesAHad() {
        return ouncesAHad;
    }

    /**
     * Returns the number of drink had
     * @return number of drinks had
     */
    public int getDrinksHad() {
        return drinksHad;
    }

    /**
     * Returns the GT ID
     * @return GT ID
     */
    public String getID() {
        return ID;
    }

    /**
     *
     * Returns their QRCode String
     * @return QRCode String
     */
    public String getQRCode() {
        return QRCode;
    }

    /**
     * Returns the list of drinks an attendee has consumed
     * @return the list of drinks had
     */
    public List<Drink> getDrinksHadList() {
        return drinksHadList;
    }
}

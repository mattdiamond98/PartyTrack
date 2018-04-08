package edu.gatech.mdiamond8.partytrack.model.user;

import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.Party;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a part attendee
 *
 * Author Jordan Goldstein
 */
public class Attendee extends User {
    private String id;
    private String qrCode;
    private int drinksHad;
    private double ouncesAHad;
    private List<Drink> drinksHadList = new ArrayList<>();
    private Party partyAt;


    /**
     * Default Attendee Constructor
     */
    public Attendee() {
        id = "123456789";
        qrCode = "";
        type = Types.Attendee;
        drinksHad = 0;
        ouncesAHad = 0;
        partyAt = null;
    }

    /**
     * Custom Attendee Constructor
     * @param id the Gatech id of the Attendee
     * @param qrCode the Assigned qrCode of the Attendee
     * @param partyAt the party the guest is attending
     */
    public Attendee(String id, String qrCode, Party partyAt) {
        this.qrCode = qrCode;
        this.id = id;
        type = Types.Attendee;
        drinksHad = 0;
        ouncesAHad = 0;
        this.partyAt = partyAt;
    }

    /**
     * Give a drink to the attendee
     * updates their drinks had, ounces had, and drink list
     * @param drink the drink to give them
     */
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
     * Returns the GT id
     * @return GT id
     */
    public String getid() {
        return id;
    }

    /**
     *
     * Returns their qrCode String
     * @return qrCode String
     */
    public String getqrCode() {
        return qrCode;
    }

    /**
     * Returns the list of drinks an attendee has consumed
     * @return the list of drinks had
     */
    public List<Drink> getDrinksHadList() {
        return drinksHadList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Attendee) {
            Attendee other = (Attendee) obj;
            if (this.id.equals(other.id)) {
                if (this.partyAt.equals(other.partyAt)) {
                    return true;
                }
            }

        }
        return false;
    }
}

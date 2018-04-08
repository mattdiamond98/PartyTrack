package edu.gatech.mdiamond8.partytrack.model.user;

import edu.gatech.mdiamond8.partytrack.model.Drink;

/**
 * Represents a Bartender
 *
 * Author Jordan Goldstein
 */
public class Bartender extends User {
    /**
     * Bartender Constructor
     */
    public Bartender() {
        type = Types.Bartender;
    }

    /**
     * Give a drink to an attendee
     * @param guest the guest to provide with drink
     * @param drink the drink to give them
     */
    public void giveDrink(Attendee guest, Drink drink) {
        if (guest != null) {
            guest.giveDrink(drink);
        }
    }
}

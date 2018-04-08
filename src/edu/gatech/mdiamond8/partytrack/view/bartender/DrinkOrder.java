package edu.gatech.mdiamond8.partytrack.view.bartender;

import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;

public class DrinkOrder {

    private Attendee attendee;
    private Drink drink;

    public DrinkOrder(Attendee attendee, Drink drink) {
        this.attendee = attendee;
        this.drink = drink;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}

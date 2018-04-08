package edu.gatech.mdiamond8.partytrack.model.user;

import edu.gatech.mdiamond8.partytrack.model.Party;
/**
 * Represents a Bouncer
 *
 * Author Jordan Goldstein
 */
public class Bouncer extends User {
    /**
     * Bouncer Constructor
     * @param p the party the bouncer is attending
     */
    public Bouncer(Party p) {
        type = Types.Bouncer;
        this.partyAt = p;
    }

    /**
     * Create an attendee object and add them to the list
     * @param gtID the GTID of the Guest
     */
    public void allowEntry(String gtID, String qrCode) {
        Attendee newGuest = new Attendee(gtID, qrCode, partyAt);
        partyAt.addAttendee(newGuest);
    }
}

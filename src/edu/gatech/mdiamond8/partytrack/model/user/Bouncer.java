package edu.gatech.mdiamond8.partytrack.model.user;

import edu.gatech.mdiamond8.partytrack.model.Party;

import java.io.Serializable;

/**
 * Represents a Bouncer
 *
 * @author Jordan Goldstein
 */
public class Bouncer extends User implements Serializable {
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
     * @throws IllegalArgumentException if the qrCode has
     * already been used or is invalid
     */
    public void allowEntry(String gtID, String qrCode) {
        if (qrCode == null) {
            throw new IllegalArgumentException("QR Code cannot be null");
        }
        if (partyAt.getAttendees().get(qrCode) != null) {
            throw new IllegalArgumentException("Can only use a QR Code once");
        }
        Attendee newGuest = new Attendee(gtID, qrCode, partyAt);
        partyAt.addAttendee(newGuest);
    }
    public Attendee makeHalfGuest(String gtID, String name) {
        return new Attendee(gtID, "", partyAt, name);
    }
}

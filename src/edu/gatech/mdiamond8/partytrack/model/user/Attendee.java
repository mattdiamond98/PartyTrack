package edu.gatech.mdiamond8.partytrack.model.user;

/**
 * Represents a part attendee
 *
 * Author Jordan Goldstein
 */
public class Attendee extends User{
    private String ID;
    private String QRCode;

    /**
     * Default Attendee Constructor
     */
    public Attendee() {
        ID = "123456789";
        QRCode = "";
        type = Types.Attendee;
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
    }
}

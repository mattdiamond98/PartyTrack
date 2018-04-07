package edu.gatech.mdiamond8.partytrack.model.user;

/**
 * Represents a generic User
 *
 * Author Jordan Goldstein
 */
public abstract class User {
    enum Types {Attendee, Bouncer, Bartender};
    protected Types type;

    public Types getType() {
        return type;
    }
}

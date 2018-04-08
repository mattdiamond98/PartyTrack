package edu.gatech.mdiamond8.partytrack.model;

import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.model.user.Bartender;
import edu.gatech.mdiamond8.partytrack.model.user.Bouncer;
import edu.gatech.mdiamond8.partytrack.view.bartender.DrinkQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Party
 *
 * @author Jordan Goldstein
 */
public class Party {
    private List<Drink> drinkList = new ArrayList<>();
    private List<Bouncer> bouncers = new ArrayList<>();
    private List<Bartender> bartenders = new ArrayList<>();
    private Map<String, Attendee> attendees = new HashMap<>();
    private DrinkQueue drinkQueue = new DrinkQueue();
    private int drinkLimit;
    private String hostName;

    /**
     * Default Party Constructor
     * It's AEPi just servin hella beer
     */
    public Party() {
        drinkList.add(new Drink());
        hostName = "AEPi";
        drinkLimit = Integer.MAX_VALUE;
        //qrFile = null; Deprecated
    }

    /**
     * Custom Party Constructor
     * Adds Beer to drink List
     * Creates a list of the qrcodes for the party
     * @param hostName the Party Host
     * @param drinkLimit the max amount of drinks someone can have
     * @param fileName the name of the file containing all the qrCode strings
     */
    public Party(String hostName, int drinkLimit, String fileName) {
        this.hostName = hostName;
        drinkList.add(new Drink());
        this.drinkLimit = drinkLimit;
        /**Deprecated
         * try {
            FileReader file = new FileReader("Resources/" + fileName);
            qrFile = new BufferedReader(file);
            String qrCode;
            while ((qrCode = qrFile.readLine()) != null) {
                codes.add(qrCode);
            }
            qrFile.close();
        } catch (FileNotFoundException ex) {
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    /**
     * Adds a drink to the drink list of the party
     * @param name the name of the drink
     * @param aContent the alcohol content of the drink
     * @param ounces the size of the drink
     */
    public void addDrinkType(String name, double aContent, double ounces) {
        addDrinkType(new Drink(aContent, name, ounces));
    }

    /**
     * Adds a drink to the drink list of the party
     * @param drink the drink to add
     */
    public void addDrinkType(Drink drink) {
        drinkList.add(drink);
    }

    /**
     * Add a guest to the list of attendees
     * Sorts the guest list by gtID
     * @param guest the guest to add
     */
    public void addAttendee(Attendee guest) {
        attendees.put(guest.getqrCode(), guest);
    }
    /**
     * Return the Host of the Party
     * @return party host
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Returns the list of drinks allowed at the party
     * @return the drink list
     */
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    /**
     * Returns the list of approved Bartenders
     * @return bartenders list
     */
    public List<Bartender> getBartenders() {
        return bartenders;
    }

    /**
     * Returns the list of approved Bouncers
     * @return bouncers list
     */
    public List<Bouncer> getBouncers() {
        return bouncers;
    }

    /**
     * Get this list of current attendees
     * @return the list of attendees
     */
    public Map<String, Attendee> getAttendees() {
        return attendees;
    }

    /**
     * Returns the limit of drinks per person set by the host
     * @return drink limit
     */
    public int getDrinkLimit() {
        return drinkLimit;
    }

    public DrinkQueue getDrinkQueue() {
        return drinkQueue;
    }

    public void setDrinkQueue(DrinkQueue drinkQueue) {
        this.drinkQueue = drinkQueue;
    }
}

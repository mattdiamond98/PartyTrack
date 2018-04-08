package edu.gatech.mdiamond8.partytrack.model;

import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.model.user.Bartender;
import edu.gatech.mdiamond8.partytrack.model.user.Bouncer;
import edu.gatech.mdiamond8.partytrack.view.bartender.DrinkQueue;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Represents the Party
 *
 * @author Jordan Goldstein
 */
public class Party {
    private static List<Drink> drinkList = new ArrayList<>();
    private static List<Bouncer> bouncers = new ArrayList<>();
    private static List<Bartender> bartenders = new ArrayList<>();
    private static Map<String, Attendee> attendees = new HashMap<>();
    private static DrinkQueue drinkQueue = new DrinkQueue();
    private static int drinkLimit;
    private static String hostName;

    /**
     * Default Party Constructor
     * It's AEPi just servin hella beer
     */
    static {
        addDefaultDrinks();
        hostName = "AEPi";
        drinkLimit = Integer.MAX_VALUE;
    }


    public static void addDefaultDrinks() {
        try {
            Scanner scan = new Scanner(new File("/default_drinks.txt"));
            while (scan.hasNextLine()) {
                drinkList.add(Drink.parseString(scan.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a drink to the drink list of the party
     * @param name the name of the drink
     * @param aContent the alcohol content of the drink
     * @param ounces the size of the drink
     */
    public static void addDrinkType(String name, double aContent, double ounces) {
        addDrinkType(new Drink(aContent, name, ounces));
    }

    /**
     * Adds a drink to the drink list of the party
     * @param drink the drink to add
     */
    public static void addDrinkType(Drink drink) {
        drinkList.add(drink);
    }

    /**
     * Add a guest to the list of attendees
     * Sorts the guest list by gtID
     * @param guest the guest to add
     */
    public static void addAttendee(Attendee guest) {
        attendees.put(guest.getqrCode(), guest);
    }
    /**
     * Return the Host of the Party
     * @return party host
     */
    public static String getHostName() {
        return hostName;
    }

    /**
     * Returns the list of drinks allowed at the party
     * @return the drink list
     */
    public static List<Drink> getDrinkList() {
        return drinkList;
    }

    /**
     * Returns the list of approved Bartenders
     * @return bartenders list
     */
    public static List<Bartender> getBartenders() {
        return bartenders;
    }

    /**
     * Returns the list of approved Bouncers
     * @return bouncers list
     */
    public static List<Bouncer> getBouncers() {
        return bouncers;
    }

    /**
     * Get this list of current attendees
     * @return the list of attendees
     */
    public static Map<String, Attendee> getAttendees() {
        return attendees;
    }

    /**
     * Returns the limit of drinks per person set by the host
     * @return drink limit
     */
    public static int getDrinkLimit() {
        return drinkLimit;
    }

    public static DrinkQueue getDrinkQueue() {
        return drinkQueue;
    }

    public static void setDrinkQueue(DrinkQueue queue) {
        drinkQueue = queue;
    }
}

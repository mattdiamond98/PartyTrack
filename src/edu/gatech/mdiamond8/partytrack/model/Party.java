package edu.gatech.mdiamond8.partytrack.model;

import edu.gatech.mdiamond8.partytrack.model.user.Bartender;
import edu.gatech.mdiamond8.partytrack.model.user.Bouncer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Party
 *
 * Author Jordan Goldstein
 */
public class Party {
    private List<Drink> drinkList = new ArrayList<Drink>();
    private List<Bouncer> bouncers = new ArrayList<>();
    private List<Bartender> bartenders = new ArrayList<>();
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
    }

    /**
     * Custom Party Constructor
     * Adds Beer to drink List
     * @param hostName the Party Host
     * @param drinkLimit the max amount of drinks someone can have
     */
    public Party(String hostName, int drinkLimit) {
        this.hostName = hostName;
        drinkList.add(new Drink());
        this.drinkLimit = drinkLimit;
    }

    /**
     * Adds a drink to the drink list of the party
     * @param name the name of the drink
     * @param aContent the alcohol content of the drink
     * @param ounces the size of the drink
     */
    public void addDrink(String name, double aContent, double ounces) {
        drinkList.add(new Drink(aContent, name, ounces));
    }

    /**
     * Adds a drink to the drink list of the party
     * @param drink the drink to add
     */
    public void addDrink(Drink drink) {
        drinkList.add(drink);
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
     * Returns the limit of drinks per person set by the host
     * @return drink limit
     */
    public int getDrinkLimit() {
        return drinkLimit;
    }
}

package edu.gatech.mdiamond8.partytrack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Party
 *
 * Author Jordan Goldstein
 */
public class Party {
    private List<Drink> drinkList = new ArrayList<Drink>();
    private String hostName;

    /**
     * Default Party Constructor
     * It's AEPi just servin beer
     */
    public Party() {
        drinkList.add(new Drink());
        hostName = "AEPi";
    }

    /**
     * Custom Party Constructor
     * Adds Beer to drink List
     * @param hostName the Party Host
     */
    public Party(String hostName) {
        this.hostName = hostName;
        drinkList.add(new Drink());
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
     * Returns the list of drinks allowed at the party
     * @return the drink list
     */
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    /**
     * Return the Host of the Party
     * @return party host
     */
    public String getHostName() {
        return hostName;
    }
}

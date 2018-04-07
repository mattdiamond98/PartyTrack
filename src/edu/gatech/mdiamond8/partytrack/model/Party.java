package edu.gatech.mdiamond8.partytrack.model;

import java.util.ArrayList;

/**
 * Represents the Party
 *
 * Author Jordan Goldstein
 */
public class Party {
    ArrayList<Drink> drinkList = new ArrayList<Drink>();
    String hostName;
    public Party() {
        drinkList.add(new Drink());
        hostName = "AEPi";
    }
    public Party(String hostName) {
        this.hostName = hostName;
        drinkList.add(new Drink());
    }

    public void addDrink(String name, double aContent, double ounces) {
        drinkList.add(new Drink(aContent, name, ounces));
    }
    public void addDrink(Drink drink) {
        drinkList.add(drink);
    }
}

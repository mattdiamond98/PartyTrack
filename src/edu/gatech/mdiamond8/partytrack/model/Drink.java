package edu.gatech.mdiamond8.partytrack.model;

/**
 * Represents a drink
 *
 * @author Jordan Goldstein
 */
public class Drink {
    private double aContent;
    private double ounces;
    private String name;

    /**
     * Default Drink Constructor
     * Makes an 8oz Beer
     */
    public Drink() {
        aContent = .04;
        name = "Beer";
        ounces = 8.0;
    }

    /**
     * Custom Drink Constructor
     * @param a the alcohol content of the drink
     * @param n the name of the drink
     * @param o the amount of ounces of the drink
     */
    public Drink(double a, String n, double o) {
        aContent = a;
        name = n;
        ounces = 0;
    }

    /**
     * Returns the Amount of Alcohol in the Drink
     * @return the ounces of alcohol
     */
    public double getAAmount() {
        return aContent * ounces;
    }

    /**
     * Returns the name of the drink
     * @return the name of the drink
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

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
     * @param aContent the alcohol content of the drink
     * @param name the name of the drink
     * @param ounces the amount of ounces of the drink
     */
    public Drink(double aContent, String name, double ounces) {
        this.aContent = aContent;
        this.name = name;
        this.ounces = 0;
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

    public Drink parseString(String drink) {
        if (drink == null || drink.isEmpty()) throw new IllegalArgumentException();
        drink = drink.replace(" ", "");
        String[] fields = drink.split(",");
        return new Drink(
                Double.parseDouble(fields[0]),
                fields[1],
                Double.parseDouble(fields[2])
        );
    }
}

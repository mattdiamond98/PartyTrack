package edu.gatech.mdiamond8.partytrack.view.bouncer;

import edu.gatech.mdiamond8.partytrack.model.Drink;
import javafx.beans.property.SimpleStringProperty;

public class DrinkData {
    private final SimpleStringProperty name;
    private final SimpleStringProperty aContent;
    private final SimpleStringProperty ounces;

    public DrinkData(Drink drink) {
        this(drink.getName(), ""+drink.getaContent(), ""+drink.getOunces());
    }

    public DrinkData(String name, String aContent, String ounces) {
        this(new SimpleStringProperty(name),
                new SimpleStringProperty(aContent),
                new SimpleStringProperty(ounces));
    }

    public DrinkData(SimpleStringProperty name, SimpleStringProperty aContent, SimpleStringProperty ounces) {
        this.name = name;
        this.aContent = aContent;
        this.ounces = ounces;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getaContent() {
        return aContent.get();
    }

    public SimpleStringProperty aContentProperty() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent.set(aContent);
    }

    public String getOunces() {
        return ounces.get();
    }

    public SimpleStringProperty ouncesProperty() {
        return ounces;
    }

    public void setOunces(String ounces) {
        this.ounces.set(ounces);
    }
}
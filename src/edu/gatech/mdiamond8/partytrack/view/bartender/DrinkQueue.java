package edu.gatech.mdiamond8.partytrack.view.bartender;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DrinkQueue  {

    private List<DrinkOrder> currentOrders;
    private List<DrinkOrder> filledOrders;

    public DrinkQueue() {
        currentOrders = new LinkedList<>();
        filledOrders = new LinkedList<>();
    }
    public DrinkQueue(Collection<DrinkOrder> current, Collection<DrinkOrder> filled) {
        this();
        for (DrinkOrder order : current) {
            current.add(order);
        }
        for (DrinkOrder order : filled) {
            filled.add(order);
        }
    }

    public List<DrinkOrder> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<DrinkOrder> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public List<DrinkOrder> getFilledOrders() {
        return filledOrders;
    }

    public void setFilledOrders(List<DrinkOrder> filledOrders) {
        this.filledOrders = filledOrders;
    }

}

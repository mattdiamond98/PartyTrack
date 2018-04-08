package edu.gatech.mdiamond8.partytrack.view.bartender;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DrinkQueue  {

    private static List<DrinkOrder> currentOrders = new LinkedList<>();
    private static List<DrinkOrder> filledOrders = new LinkedList<>();

    public DrinkQueue(Collection<DrinkOrder> current, Collection<DrinkOrder> filled) {
        for (DrinkOrder order : current) {
            current.add(order);
        }
        for (DrinkOrder order : filled) {
            filled.add(order);
        }
    }

    public static List<DrinkOrder> getCurrentOrders() {
        return currentOrders;
    }

    public static void setCurrentOrders(List<DrinkOrder> currentOrders) {
        currentOrders = currentOrders;
    }

    public static List<DrinkOrder> getFilledOrders() {
        return filledOrders;
    }

    public static void setFilledOrders(List<DrinkOrder> filledOrders) {
        filledOrders = filledOrders;
    }

}

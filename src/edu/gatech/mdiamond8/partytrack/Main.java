package edu.gatech.mdiamond8.partytrack;

import edu.gatech.mdiamond8.partytrack.Network.NetworkCode;
import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.view.LoginScreen;
import edu.gatech.mdiamond8.partytrack.view.bartender.DrinkOrder;
import edu.gatech.mdiamond8.partytrack.view.bartender.DrinkQueue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main extends Application {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            if (args[0].equals("Delete")) {
                try {
                    NetworkCode.deleteAttendees();
                    NetworkCode.deleteDrinkOrderList();
                    NetworkCode.deleteDrinksOrderedList();
                } catch (Exception ex) {

                }
                try {
                    NetworkCode.makeAttendees();
                    NetworkCode.makeDrinkOrderList();
                    NetworkCode.makeDrinksFilledList();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(69);
                }
            }
        }
        try {
            ResultSet rs = NetworkCode.getDrinkOrders();
            while (rs.next()) {
                Attendee guest = NetworkCode.getAttendeeByName(rs.getString("Name"));
                NetworkCode.addGuest(guest);
                DrinkQueue.getCurrentOrders().add(new DrinkOrder(guest, new Drink(0, rs.getString("Drink"), 0)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        Scene scene = new Scene(LoginScreen.getParent(primaryStage), Config.SCREEN_X / 2, Config.SCREEN_Y / 2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
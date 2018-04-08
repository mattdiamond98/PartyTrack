package edu.gatech.mdiamond8.partytrack;

import edu.gatech.mdiamond8.partytrack.Network.NetworkCode;
import edu.gatech.mdiamond8.partytrack.view.LoginScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Main extends Application {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            if (args[0].equals("Delete")) {
                try {
                    NetworkCode.deleteAttendees();
                    NetworkCode.deleteDrinkOrderList();
                } catch (Exception ex) {

                }
                try {
                    NetworkCode.makeAttendees();
                    NetworkCode.makeDrinkOrderList();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(69);
                }
            }
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
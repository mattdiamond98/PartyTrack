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
        try {
            NetworkCode.deleteAttendees();
        } catch (Exception ex) {

        }
        try {
            NetworkCode.makeAttendees();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(69);
        }
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        Scene scene = new Scene(LoginScreen.getParent(primaryStage), Config.SCREEN_X, Config.SCREEN_Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
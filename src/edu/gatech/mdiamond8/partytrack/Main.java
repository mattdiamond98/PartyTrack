package edu.gatech.mdiamond8.partytrack;

import edu.gatech.mdiamond8.partytrack.view.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");


        Scene scene = new Scene(Login.getPane(), 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
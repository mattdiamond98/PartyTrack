package edu.gatech.mdiamond8.partytrack.view.bouncer;

import edu.gatech.mdiamond8.partytrack.Network.NetworkCode;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.qr.QRReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BouncerScreen {

    public static Parent getParent(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Sign In");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("GTID:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 2);
        TextField nameField = new PasswordField();
        grid.add(nameField, 1, 2);

        Button btn1 = new Button("Scan Wristband");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 1, 4);

        btn1.setOnAction(e -> { //scan wristband button
            Attendee guest = new Attendee(userTextField.getText(), "", null, nameField.getText());

            QRReader qrReader = new QRReader(x -> {
                guest.setCode(x);
                System.out.println(guest.getqrCode());
            });
            qrReader.start();
            try {
                qrReader.t.join();
            } catch (Exception ex) {

            }
            try {
                NetworkCode.addGuest(guest);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            nameField.setText("");
            userTextField.setText("");

        });

        Button btn2 = new Button("Cancel");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 1, 5);

        btn2.setOnAction(e -> { //cancel button

        });
        return grid;

    }

}

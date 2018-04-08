package edu.gatech.mdiamond8.partytrack.view.bartender;

import edu.gatech.mdiamond8.partytrack.Config;
import edu.gatech.mdiamond8.partytrack.Network.NetworkCode;
import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.Party;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.qr.QRReader;
import edu.gatech.mdiamond8.partytrack.qr.QRImage;
import edu.gatech.mdiamond8.partytrack.view.HomeScreen;
import edu.gatech.mdiamond8.partytrack.view.bouncer.DrinkData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static edu.gatech.mdiamond8.partytrack.view.bartender.BartenderScreen.genData;

public class DrinksScreen {

    private static TableView<DrinkData> table = new TableView<>();
    static List<DrinkData> drinks = Party.getDrinkList().stream().map(e -> new DrinkData(e)).collect(Collectors.toList()); //look at this smexy syntax right here
    private static final ObservableList<DrinkData> data = FXCollections.observableArrayList(drinks);

    private static Drink selected;

    public static Parent getParent(Stage primaryStage) {
        System.out.println(drinks);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 0, 25));

        table.setEditable(true);

        TableColumn drinkNameCol = new TableColumn("Drink");
        drinkNameCol.setMinWidth(300);
        drinkNameCol.setCellValueFactory(
                new PropertyValueFactory<BartenderScreen.OrderData, String>("name"));

        TableColumn alcoholColumn = new TableColumn("Alcohol");
        alcoholColumn.setMinWidth(200);
        alcoholColumn.setCellValueFactory(
                new PropertyValueFactory<BartenderScreen.OrderData, String>("aContent"));

        TableColumn ouncesCol = new TableColumn("Volume");
        ouncesCol.setMinWidth(200);
        ouncesCol.setCellValueFactory(
                new PropertyValueFactory<BartenderScreen.OrderData, String>("ounces"));

        table.setItems(data);
        table.getColumns().addAll(drinkNameCol, alcoholColumn, ouncesCol);

        table.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<? super DrinkData>) (ov, old_val, new_val) -> {
                    selected = new_val.toDrink(); //delete this and the variable if you don't need


                            //Do any code here jordan



                });


        Text scenetitle = new Text("Drinks");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 1, 1, 1, 1);


        Button btn1 = new Button("Scan Wristband");
        btn1.setOnAction(e -> { //scan wristband button
            Attendee guest = new Attendee(null,null,null,null);
            QRReader qrReader = new QRReader(x -> {
                Attendee temp;
                try {
                    temp = NetworkCode.getAttendee(x);
                } catch (Exception ex) {
                    temp = new Attendee(null,null,null,null);
                    ex.printStackTrace();
                }
                guest.setCode(temp.getqrCode());
                guest.setName(temp.getName());
                guest.setId(temp.getid());
                guest.setDrinksHad(temp.getDrinksHad());
                guest.setOuncesAHad(temp.getOuncesAHad());
            });
            qrReader.start();
            try {
                qrReader.t.join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            DrinkQueue.getCurrentOrders().add(new DrinkOrder(guest, selected));
        });
        final Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), Config.SCREEN_X, Config.SCREEN_Y);
            primaryStage.setScene(scene);
        });
        Button btn2 = new Button("Cancel");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().addAll(backButton, btn1, btn2);
        grid.add(hbBtn2, 1, 2);

        btn2.setOnAction(e -> { //cancel button
            QRReader.coolRunning = false;
        });



        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(grid, table);
        return vbox;
    }

}

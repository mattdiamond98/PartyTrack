package edu.gatech.mdiamond8.partytrack.view.bartender;

import edu.gatech.mdiamond8.partytrack.Config;
import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.view.HomeScreen;
import edu.gatech.mdiamond8.partytrack.view.bouncer.DrinkData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BartenderScreen {

    private static TableView<OrderData> table = new TableView<>();
    private static final ObservableList<OrderData> data =
            FXCollections.observableArrayList(
                    (ArrayList<OrderData>) DrinkQueue.getCurrentOrders()
                            .stream().map(e -> genData(e)).collect(Collectors.toList())
            );

    public static Parent getParent(Stage primaryStage) {
        Group group = new Group();
        final Label label = new Label("Current Orders");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn drinkNameCol = new TableColumn("Drink");
        drinkNameCol.setMinWidth(300);
        drinkNameCol.setCellValueFactory(
                new PropertyValueFactory<OrderData, String>("drinkName"));

        TableColumn personNameCol = new TableColumn("Person");
        personNameCol.setMinWidth(300);
        personNameCol.setCellValueFactory(
                new PropertyValueFactory<OrderData, String>("personName"));

        TableColumn drinksHadCol = new TableColumn("Drinks Had");
        drinksHadCol.setMinWidth(100);
        drinksHadCol.setCellValueFactory(
                new PropertyValueFactory<OrderData, String>("drinksHad"));

        TableColumn ouncesHadCol = new TableColumn("Ounces Had");
        ouncesHadCol.setMinWidth(100);
        ouncesHadCol.setCellValueFactory(
                new PropertyValueFactory<OrderData, String>("ouncesHad"));

        table.setItems(data);
        table.getColumns().addAll(drinkNameCol, personNameCol, drinksHadCol, ouncesHadCol);

        table.setRowFactory( tv -> {
            TableRow<OrderData> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    String name = row.getItem().getPersonName();


                    //any code here @jordan


                    table.getItems().remove(row.getItem());
                }
            });
            return row ;
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        final Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), Config.SCREEN_X, Config.SCREEN_Y);
            primaryStage.setScene(scene);
        });
        vbox.getChildren().addAll(label, table, backButton);

        group.getChildren().addAll(vbox);
        return group;
    }

    public static OrderData genData(DrinkOrder order) {
        return new OrderData(
                new SimpleStringProperty(order.getDrink().getName()),
                new SimpleStringProperty(order.getAttendee().getName()),
                new SimpleStringProperty(""+order.getAttendee().getDrinksHad()),
                new SimpleStringProperty(""+order.getAttendee().getOuncesAHad()));
    }

    public static class OrderData {

        private final SimpleStringProperty drinkName;
        private final SimpleStringProperty personName;
        private final SimpleStringProperty drinksHad;
        private final SimpleStringProperty ouncesHad;

        public OrderData(SimpleStringProperty drinkName, SimpleStringProperty personName,
                         SimpleStringProperty drinksHad, SimpleStringProperty ouncesHad) {
            this.drinkName = drinkName;
            this.personName = personName;
            this.drinksHad = drinksHad;
            this.ouncesHad = ouncesHad;
        }

        public String getDrinkName() {
            return drinkName.get();
        }

        public SimpleStringProperty drinkNameProperty() {
            return drinkName;
        }

        public void setDrinkName(String drinkName) {
            this.drinkName.set(drinkName);
        }

        public String getPersonName() {
            return personName.get();
        }

        public SimpleStringProperty personNameProperty() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName.set(personName);
        }

        public String getDrinksHad() {
            return drinksHad.get();
        }

        public SimpleStringProperty drinksHadProperty() {
            return drinksHad;
        }

        public void setDrinksHad(String drinksHad) {
            this.drinksHad.set(drinksHad);
        }

        public String getOuncesHad() {
            return ouncesHad.get();
        }

        public SimpleStringProperty ouncesHadProperty() {
            return ouncesHad;
        }

        public void setOuncesHad(String ouncesHad) {
            this.ouncesHad.set(ouncesHad);
        }

    }
}
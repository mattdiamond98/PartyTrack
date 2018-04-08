package edu.gatech.mdiamond8.partytrack.view.admin;

import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.Party;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdminScreen {

    private static TableView<DrinkData> table = new TableView<>();
    private static final ObservableList<DrinkData> data =
            FXCollections.observableArrayList(getData());
    static final HBox hb = new HBox();

    public static Parent getParent(Stage mainStage) {
        Group group = new Group();

        final Label label = new Label("Party Drinks");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Drink Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<DrinkData, String>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                (EventHandler<CellEditEvent<DrinkData, String>>) t -> ((DrinkData) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setName(t.getNewValue())
        );


        TableColumn alcCol = new TableColumn("Alcohol Content");
        alcCol.setMinWidth(100);
        alcCol.setCellValueFactory(
                new PropertyValueFactory<DrinkData, String>("aContent"));
        alcCol.setCellFactory(TextFieldTableCell.forTableColumn());
        alcCol.setOnEditCommit(
                (EventHandler<CellEditEvent<DrinkData, String>>) t -> ((DrinkData) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setaContent(t.getNewValue())
        );

        TableColumn volumeCol = new TableColumn("Volume");
        volumeCol.setMinWidth(200);
        volumeCol.setCellValueFactory(
                new PropertyValueFactory<DrinkData, String>("ounces"));
        volumeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        volumeCol.setOnEditCommit(
                (EventHandler<CellEditEvent<DrinkData, String>>) t -> ((DrinkData) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setOunces(t.getNewValue())
        );

        table.setItems(data);
        table.getColumns().addAll(nameCol, alcCol, volumeCol);

        final TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMaxWidth(nameCol.getPrefWidth());
        final TextField addAlcohol = new TextField();
        addAlcohol.setMaxWidth(alcCol.getPrefWidth());
        addAlcohol.setPromptText("Alcohol");
        final TextField addOunces = new TextField();
        addOunces.setMaxWidth(volumeCol.getPrefWidth());
        addOunces.setPromptText("Ounces");

        final Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            data.add(new DrinkData(
                    addName.getText(),
                    addAlcohol.getText(),
                    addOunces.getText()));
            addName.clear();
            addAlcohol.clear();
            addOunces.clear();
        });

        hb.getChildren().addAll(addName, addAlcohol, addOunces, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        group.getChildren().addAll(vbox);

        return group;
    }

    private static List<DrinkData> getData() {
        List<DrinkData> list = new ArrayList<>();
        for (Drink drink : Party.getDrinkList()) {
            list.add(new DrinkData(
                    new SimpleStringProperty(drink.getName()),
                    new SimpleStringProperty("" + drink.getaContent()),
                    new SimpleStringProperty("" + drink.getOunces())
            ));

        }
        return list;
    }

    public static class DrinkData {
        private final SimpleStringProperty name;
        private final SimpleStringProperty aContent;
        private final SimpleStringProperty ounces;

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
}

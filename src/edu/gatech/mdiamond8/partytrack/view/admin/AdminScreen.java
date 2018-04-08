package edu.gatech.mdiamond8.partytrack.view.admin;

import edu.gatech.mdiamond8.partytrack.Config;
import edu.gatech.mdiamond8.partytrack.Network.NetworkCode;
import edu.gatech.mdiamond8.partytrack.excel.ExcelWriter;
import edu.gatech.mdiamond8.partytrack.model.Drink;
import edu.gatech.mdiamond8.partytrack.model.Party;
import edu.gatech.mdiamond8.partytrack.view.HomeScreen;
import edu.gatech.mdiamond8.partytrack.view.bouncer.DrinkData;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jxl.write.WriteException;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminScreen {



    public static Parent getParent(Stage primaryStage) {
        TableView<DrinkData> table = new TableView<>();
        final ObservableList<DrinkData> data =
                FXCollections.observableArrayList(getData());
        final HBox hb = new HBox();
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
            Party.getDrinkList().add(new Drink(
                    Double.parseDouble(addAlcohol.getText()),
                    addName.getText(),
                    Double.parseDouble(addOunces.getText())));
            data.add(new DrinkData(
                    addName.getText(),
                    addAlcohol.getText(),
                    addOunces.getText()));

            addName.clear();
            addAlcohol.clear();
            addOunces.clear();
        });

        final Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), Config.SCREEN_X / 2, Config.SCREEN_Y / 2);
            primaryStage.setScene(scene);
        });


        final Button exportButton = new Button("Export Data to File");
        exportButton.setOnAction(e -> {
            ExcelWriter test = new ExcelWriter();

            try {
                ResultSet resultSet = NetworkCode.getDrinksOrdered();
                test.setOutputFile("Resources/data.xls", resultSet);
                test.write();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        hb.getChildren().addAll(addName, addAlcohol, addOunces, addButton, exportButton, backButton);
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


}

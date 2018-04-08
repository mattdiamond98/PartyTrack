package edu.gatech.mdiamond8.partytrack.view;

/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;

/**
 *
 * Sample that shows how touch events can be used. UI contains four folders
 * and a row of blocks with a circle on one of the blocks. The folders
 * can be moved independently by touching one or more simultaneously
 * (number of folders that can be moved at one time can be limited by the
 * number of touch points the screen supports).
 * The circle can be moved from block to block by first touching the circle
 * and then touching an empty block. Jumping can continue until the finger
 * over the circle is removed.
 *
 */
public class HomeScreen {

    public static Parent getParent(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Who are you");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        grid.add(scenetitle, 0, 0, 2, 1);


        Button bartenderButton = new Button("Bartender");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.CENTER);
        hbBtn1.getChildren().add(bartenderButton);
        grid.add(hbBtn1, 1, 1);
        bartenderButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), 300, 275);
            primaryStage.setScene(scene);
        });

        HBox hbBtn2 = new HBox(10);
        Button drinksButton = new Button("Drinks");
        hbBtn2.setAlignment(Pos.CENTER);
        hbBtn2.getChildren().add(drinksButton);
        grid.add(hbBtn2, 1, 2);
        drinksButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), 300, 275);
            primaryStage.setScene(scene);
        });

        HBox hbBtn3 = new HBox(10);
        Button bouncerButton = new Button("Bouncer");
        hbBtn3.setAlignment(Pos.CENTER);
        hbBtn3.getChildren().add(bouncerButton);
        grid.add(hbBtn3, 1, 3);
        bouncerButton.setOnAction(e -> {
            Scene scene = new Scene(HomeScreen.getParent(primaryStage), 300, 275);
            primaryStage.setScene(scene);
        });
        return grid;
    }
}

package com.milto.worldmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        Properties population = new Properties();
        Properties description = new Properties();
        Properties cities = new Properties();

        File fileWithPopulation = new File("E:\\World Map\\MyWorldMap\\src\\main\\resources\\population.properties");
        File fileWithDescription = new File("E:\\World Map\\MyWorldMap\\src\\main\\resources\\description.properties");
        File fileWithCities = new File("E:\\World Map\\MyWorldMap\\src\\main\\resources\\cities.properties");

        try {
            FileInputStream streamPopulation = new FileInputStream(fileWithPopulation);
            population.load(new InputStreamReader(streamPopulation, StandardCharsets.UTF_8));
            FileInputStream streamDescription = new FileInputStream(fileWithDescription);
            description.load(new InputStreamReader(streamDescription, StandardCharsets.UTF_8));
            FileInputStream streamCities = new FileInputStream((fileWithCities));
            cities.load(streamCities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var label = new Label("Hello, JavaFX " + javafxVersion +  ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
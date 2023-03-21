package com.example.eindopdracht;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {
    public Label DataStructuren;
    public Label ZoekAlgoritmes;
    public Label sorteerAlgoritmes;
    public Button test;
    @FXML
    private Label welcomeText;
    public FileChooser fileChooser;

    public final Stage primaryStage;

    public HelloController(){
        this.primaryStage = new Stage();
        this.fileChooser = new FileChooser();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void createBinaryTree(){

    }
    @FXML
    public void createStack(){

    }
    @FXML
    public void createLinkedList(){

    }

    @FXML
    public void searchAlgorithm1(){

    }
    @FXML
    public void searchAlgorithm2(){

    }
    @FXML
    public void sortAlgorithm1(){

    }
    @FXML
    public void sortAlgorithm2(){

    }

    @FXML
    public void selectFile(){
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(selectedFile.toURI())))) {

            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
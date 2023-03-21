package com.example.eindopdracht;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {
    public Label datastructures;
    public Label ZoekAlgoritmes;
    public Label sorteerAlgoritmes;
    public Button test;
    public ChoiceBox choiceBox;
    public FileChooser fileChooser;
    public final Stage primaryStage;
    public BufferedReader reader;

    public HelloController(){
        this.primaryStage = new Stage();
        this.fileChooser = new FileChooser();
    }


    @FXML
    public void createBinaryTree(){
        System.out.println("Binary tree");
    }
    @FXML
    public void createStack(){
        System.out.println("Stack");
    }
    @FXML
    public void createLinkedList(){
        System.out.println("Linked list");
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
    public void selectFile() throws IOException {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        this.reader = new BufferedReader(new FileReader(new File(selectedFile.toURI())));

            String line;
            while ((line = this.reader.readLine()) != null)

                System.out.println(line);


    }
    public void toDatastructure(){
        String value = (String) choiceBox.getValue();
        switch (value){
            case "Stack":
                createStack();
                break;
            case "Binary Tree":
                createBinaryTree();
                break;
            case "Linked List":
                createLinkedList();
                break;
        }
    }

    public void readFile() throws IOException {
//        System.out.println(reader);
        String line;
        while ((line = reader.readLine()) != null)

            System.out.println(line);
    }
}
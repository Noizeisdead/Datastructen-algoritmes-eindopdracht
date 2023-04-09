package GUI;

import Datastructures.BinaryTree;
import Datastructures.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HelloController {
    public Label datastructures;
    public Label zoekAlgoritmes;
    public Label sorteerAlgoritmes;
    public Button test;
    public ChoiceBox choiceBox;
    public FileChooser fileChooser;
    public final Stage primaryStage;
    public BufferedReader reader;
    public TextField searchValue;

    private ArrayList<Integer> arrayList;
    private BinaryTree bt;
    private Stack stack;

    public HelloController(){
        this.primaryStage = new Stage();
        this.fileChooser = new FileChooser();

    }


    @FXML
    public void createBinaryTree(){
        System.out.println("Binary tree");
        this.bt = new BinaryTree();
        if (!this.arrayList.isEmpty()) {
            for (int element : arrayList) {
                this.bt.insert(element);
            }
            //stack.printStack(this.stack);
            bt.inOrder(bt.getRoot());
        }else{
            System.out.println("add file please.");
        }

    }
    @FXML
    public void createStack() throws Exception {
        System.out.println("Stack");
        this.stack = new Stack(20);
        if (!this.arrayList.isEmpty()) {
            for (int element : arrayList) {
                this.stack.push(element);
            }
            stack.printStack(this.stack);
        }else{
            System.out.println("add file please.");
        }
    }
    @FXML
    public void createLinkedList(){
        System.out.println("Linked list");
    }

    @FXML
    public void searchBinary(){
        System.out.println(bt.search(Integer.parseInt(searchValue.getText())));
        System.out.println("O(N)");
    }
    @FXML
    public void searchLinear(){

    }
    @FXML
    public void sortStack() throws Exception {
        System.out.println("O(N^2)");
        this.stack.printStack(this.stack.sort());

    }
    @FXML
    public void sortBubble(){

    }

    @FXML
    public void selectFile() throws IOException {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        this.arrayList = new ArrayList<>();
        if(selectedFile != null){
            this.reader = new BufferedReader(new FileReader(new File(selectedFile.toURI())));

            String line;
            while ((line = this.reader.readLine()) != null)

                arrayList.add(Integer.valueOf(line));
        }

    }

    public void toDatastructure() throws Exception {
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
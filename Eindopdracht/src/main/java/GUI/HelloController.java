package GUI;

import Datastructures.BinaryTree;
import Datastructures.LinkedList;
import Datastructures.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HelloController {
    public Label datastructures;
    public static Label zoekAlgoritmes;
    public Label sorteerAlgoritmes;
    public Button test;
    public ChoiceBox choiceBox;
    public FileChooser fileChooser;
    public final Stage primaryStage;
    public BufferedReader reader;
    public TextField searchValue;

    public Text error;
    public Text nameDatastructure;
    public Text datastructure;
    public Text bigONot;
    public Text nameAlgorithm;
    public Text output;
    private ArrayList<Integer> arrayList;
    private BinaryTree bt;
    private Stack stack;
    private LinkedList linkedList;

    public HelloController() {
        this.primaryStage = new Stage();
        this.fileChooser = new FileChooser();

    }


    @FXML
    public void createBinaryTree() {
        System.out.println("Binary tree");
        this.bt = new BinaryTree();
        if (!(this.arrayList == null)) {

            for (int element : arrayList) {
                this.bt.insert(element);
            }
            //stack.printStack(this.stack);
            bt.preOrder(bt.getRoot());
            String datastructureString = arrayListToString();
            nameDatastructure.setText("BinaryTree");
            datastructure.setText(datastructureString);
        } else {
            error.setText("Add file please.");
            System.out.println("add file please.");
        }

    }

    @FXML
    public void createStack() throws Exception {
        System.out.println("Stack");
        this.stack = new Stack(20);
        if (!(this.arrayList == null)) {
            for (int element : arrayList) {
                this.stack.push(element);
            }
            String datastructureString = arrayListToString();
            nameDatastructure.setText("Stack");
            datastructure.setText(datastructureString);
        } else {
            System.out.println("add file please.");
        }
    }

    @FXML
    public void createLinkedList() {
        System.out.println("Linked list");
        LinkedList linkedList1 = new LinkedList();
        if (!(this.arrayList == null)) {
            for (int element : arrayList) {
                //add elements to LinkedList
                linkedList1.insert(element);
            }
            String datastructureString = arrayListToString();
            nameDatastructure.setText("LinkedList");
            datastructure.setText(datastructureString);
        } else {
            System.out.println("add file please.");
        }
    }

    @FXML
    public void searchBinary() {
        if (searchValue.getText().isEmpty()) {
            error.setText("Please input a number to search");
        } else {
            System.out.println(bt.search(Integer.parseInt(searchValue.getText())));
            String stringOutput = String.valueOf(bt.search(Integer.parseInt(searchValue.getText())));
            bigONot.setText("O(N)");
            output.setText(stringOutput);
            nameAlgorithm.setText("Binary search");
        }
    }

    @FXML
    public void searchLinear() {
        if (searchValue.getText().isEmpty()) {
            error.setText("Please input a number to search");
        } else {
            //do search
            String stringOutput = "Output of algorithm";
            bigONot.setText("Algorithm speed");
            output.setText(stringOutput);
            nameAlgorithm.setText("Linear search");
        }
    }

    @FXML
    public void sortStack() throws Exception {
        StringBuilder listString = new StringBuilder();
        Stack sortedStack = this.stack.sort();

        for (int i = 0; i <= sortedStack.size(); i++) {
            int x = this.stack.printStack(sortedStack);
            System.out.println(x);
            listString.append(x).append("\t");
        }

        String stringOutput = listString.toString();
        ;
        bigONot.setText("O(N^2)");
        output.setText(stringOutput);
        nameAlgorithm.setText("Stack sort");
    }

    @FXML
    public void sortBubble() {
        StringBuilder listString = new StringBuilder();
        this.linkedList.bubbleSort();

        for (int i = 0; i <= sortedStack.size(); i++) {
            int x = this.stack.printStack(sortedStack);
            System.out.println(x);
            listString.append(x).append("\t");
        }

        String stringOutput = listString.toString();
        ;
        bigONot.setText("O(N^2)");
        output.setText(stringOutput);
        nameAlgorithm.setText("Stack sort");
    }

    @FXML
    public void selectFile() throws IOException {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        this.arrayList = new ArrayList<>();
        if (selectedFile != null) {
            this.reader = new BufferedReader(new FileReader(new File(selectedFile.toURI())));

            String line;
            while ((line = this.reader.readLine()) != null)

                arrayList.add(Integer.valueOf(line));
        }

    }

    public void toDatastructure() throws Exception {
        String value = (String) choiceBox.getValue();
        switch (value) {
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

    private String arrayListToString() {
        StringBuilder listString = new StringBuilder();
        for (int s : this.arrayList) {
            listString.append(s).append("\t");
        }
        return listString.toString();
    }
}
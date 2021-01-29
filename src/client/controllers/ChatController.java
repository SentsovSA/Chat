package client.controllers;

import client.models.Network;
import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChatController {
    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> usersListView;

    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }


    private final ObservableList<String> wordList = FXCollections.observableArrayList("Приветствую в своём первом чате!");

    private final ObservableList<String> usersList = FXCollections.observableArrayList("SentsovSA");

    @FXML
    void initialize() {
        listView.setItems(wordList);
        usersListView.setItems(usersList);
    }


    @FXML
    void sendMessage() {
        String message = inputField.getText().trim();
        if (message.length() != 0) {
            addMessageToList(message);

            try {
                network.getOut().writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Sending message error");
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Ошибка ввода сообщения");
            alert.setContentText("Введено пустое сообщение");
            alert.show();
        } ;
        inputField.clear();
    }

    public void addMessageToList(String message) {
        listView.getItems().add(message);
    }


    @FXML
    void showAbout() {
        System.out.println("about");
    }

    @FXML
    void addClient() {

    }
}

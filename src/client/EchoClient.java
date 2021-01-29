package client;

import client.controllers.ChatController;
import client.models.Network;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(EchoClient.class.getResource("views/chat.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("SentsovSA Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Network network = new Network();
        network.connect();

        ChatController chatController = fxmlLoader.getController();
        chatController.setNetwork(network);

        network.waitMessage(chatController);

        Thread thread1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            String serverMessage = scanner.next();
            System.out.println("Ответ сервера: " + serverMessage);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}


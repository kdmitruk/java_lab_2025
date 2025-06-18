package pl.umcs.gui_client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ChatController {
    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private ListView<String> clientList;

    private Client client;

    @FXML
    protected void onSend() {
        //outputArea.setText(inputField.getText());
        client.send(inputField.getText());
    }
    @FXML
    private void initialize() throws IOException {
        client = new Client();
        client.setOnMessageReceived(this::receiveMessage);
        client.setOnAddUser(this::addUserToList);
        client.setOnRemoveUser(this::removeUserFromList);
        client.setOnLoadUsers(this::reloadUserList);
        client.connect("localhost", 3000);
        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("login: ");
        Optional<String> login  = dialog.showAndWait();
        if(login.isPresent()){
            client.send(login.get());
            Thread clientThread = new Thread(client);
            clientThread.start();
        } else{
            System.exit(1);
        }
    }

    private void receiveMessage (String message){
        inputField.clear();
        outputArea.appendText(message+"\n");
    }

    private void reloadUserList(List<String> users) {
        Platform.runLater(() -> {
            clientList.getItems().clear();
            users.forEach(user -> clientList.getItems().add(user));
        });

    }

    private void addUserToList(String user) {
        Platform.runLater(() -> {
            clientList.getItems().add(user);
        });
    }

    private void removeUserFromList(String user) {
        Platform.runLater(() -> {
            clientList.getItems().remove(user);
        });
    }

}
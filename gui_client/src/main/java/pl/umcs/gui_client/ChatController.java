package pl.umcs.gui_client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

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
        client.connect("localhost", 3000);
    }

}
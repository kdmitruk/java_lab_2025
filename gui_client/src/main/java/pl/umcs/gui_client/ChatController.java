package pl.umcs.gui_client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private ListView<String> clientList;

    @FXML
    protected void onSend() {
        outputArea.setText(inputField.getText());
    }
}
module pl.umcs.gui_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.umcs.gui_client to javafx.fxml;
    exports pl.umcs.gui_client;
}
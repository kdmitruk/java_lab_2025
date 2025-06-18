module pl.umcs.gui_client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens pl.umcs.gui_client to javafx.fxml;
    exports pl.umcs.gui_client;
}
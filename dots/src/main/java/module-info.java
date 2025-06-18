module pl.umcs.dots {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.umcs.dots to javafx.fxml;
    exports pl.umcs.dots;
}
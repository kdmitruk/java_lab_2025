module pl.umcs.dots {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pl.umcs.dots to javafx.fxml;
    exports pl.umcs.dots;
}
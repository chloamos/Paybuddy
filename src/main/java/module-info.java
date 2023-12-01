module edu.lawrence.paybuddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens edu.lawrence.paybuddy to javafx.fxml;
    exports edu.lawrence.paybuddy;
}

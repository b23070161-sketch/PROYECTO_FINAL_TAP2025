module org.example.cinetec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.ikonli.javafx;
    requires mysql.connector.j;

    opens app to javafx.fxml;
    exports app;
    exports controller.login;
    opens controller.login to javafx.fxml;
}
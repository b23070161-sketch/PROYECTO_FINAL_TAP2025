module org.example.cinetec {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens model to javafx.fxml;
    exports app;
}
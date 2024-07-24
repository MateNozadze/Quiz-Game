module com.example.quiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens com.example.quiz to javafx.fxml;
    exports com.example.quiz;
}

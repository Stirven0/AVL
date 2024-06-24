module com.mycompany.avl {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.mycompany.avl to javafx.fxml;
    opens Oters to javafx.base;
    exports com.mycompany.avl;
}

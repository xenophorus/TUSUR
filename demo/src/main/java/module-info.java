module ru.xeno.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ru.xeno.nBook to javafx.fxml;
    exports ru.xeno.nBook;
}
module ru.xeno.notepad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens ru.xeno.notepad to javafx.fxml;
    exports ru.xeno.notepad;
}
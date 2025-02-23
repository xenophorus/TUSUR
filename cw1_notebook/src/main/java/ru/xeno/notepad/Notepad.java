package ru.xeno.notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Notepad extends Application {

    protected static Stage st;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Notepad.class.getResource("notepad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Notepad by Shesterin A.");
        stage.setScene(scene);
        st = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}




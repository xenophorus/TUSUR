package ru.xeno.notepad;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.io.*;
import java.nio.file.Files;
import java.util.Optional;

public class NotepadController {

    public TextField textToFind;
    public TextField textToReplace;
    public Button findReplaceButton;
    @FXML protected CheckMenuItem msWrap;
    @FXML protected MenuItem eFind;
    @FXML protected MenuItem ePaste;
    @FXML protected MenuItem eCut;
    @FXML protected MenuItem eCopy;
    @FXML protected MenuItem eUndo;
    @FXML protected MenuItem eRedo;
    @FXML protected MenuItem fNew;
    @FXML protected MenuItem fOpen;
    @FXML protected MenuItem fSave;
    @FXML protected MenuItem fSaveAs;
    @FXML protected VBox panelFind;
    @FXML protected HBox fileReplace;
    @FXML protected CheckBox toReplace;
    @FXML protected TextArea textArea;
    protected File workFile;
    protected boolean textIsChanged = false;
    protected boolean isWrap = false;
    private int foundIdx = 0;
    private int replaceCount = 0;
    private boolean docIsEnded = false;

    @FXML
    protected void initialize() {
        panelFind.setVisible(false);
        panelFind.setManaged(false);
        fileReplace.setVisible(false);
        fileReplace.setManaged(false);

        this.fOpen.setAccelerator(kFOpen);
        this.fNew.setAccelerator(kFNew);
        this.fSave.setAccelerator(kFSave);
        this.fSaveAs.setAccelerator(kFSaveAs);
        this.eCopy.setAccelerator(kECopy);
        this.eCut.setAccelerator(kECut);
        this.ePaste.setAccelerator(kEPaste);
        this.eUndo.setAccelerator(kEUndo);
        this.eRedo.setAccelerator(kERedo);
        this.eFind.setAccelerator(kEFind);
        this.msWrap.setAccelerator(kSWrap);
    }

    @FXML
    protected void showFindPanel() {
        panelFind.setVisible(true);
        panelFind.setManaged(true);
    }

    @FXML
    protected void closePanel() {
        panelFind.setVisible(false);
        panelFind.setManaged(false);
        fileReplace.setVisible(false);
        fileReplace.setManaged(false);
        toReplace.setSelected(false);
        textToFind.setText("");
        textToReplace.setText("");
    }

    @FXML
    protected void showReplacePanel() {
        if (toReplace.isSelected()) {
            fileReplace.setVisible(true);
            fileReplace.setManaged(true);
            findReplaceButton.setText("Заменить");
        } else {
            fileReplace.setVisible(false);
            fileReplace.setManaged(false);
            findReplaceButton.setText("Найти");
        }
    }

    private void textAreaSettings() {
        this.textArea.setTextFormatter(new TextFormatter<String>(change -> {
            this.textIsChanged = true;
            return change;
        }));
    }

    @FXML
    protected void openFile() throws IOException {
        this.newFile();

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text files",
                "*.txt", "*.csv", "*.tsv");
        fileChooser.setSelectedExtensionFilter(extensionFilter);

        this.workFile = fileChooser.showOpenDialog(Notepad.st);
        if (this.workFile != null) {
            this.textArea.appendText(Files.readString(this.workFile.toPath()));
            textArea.toFront();
            textArea.selectPositionCaret(0);
            textArea.deselect();
            this.textIsChanged = false;
        }
    }

    @FXML
    protected void saveFile() throws IOException {
        if (this.workFile == null || !this.workFile.isFile()) {
            this.saveAsFile();
        } else {
            Files.writeString(this.workFile.toPath(), this.textArea.getText());
        }
    }

    @FXML
    protected void saveAsFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File f = fileChooser.showSaveDialog(Notepad.st);
        if (f != null && f.exists() && f.isFile()) {
            Files.writeString(f.toPath(), this.textArea.getText());
        }
    }

    @FXML
    protected void newFile() throws IOException {
        if (textIsChanged) {
            Alert alertDialog = new Alert(Alert.AlertType.CONFIRMATION);
            alertDialog.setTitle("Файл изменен!");
            alertDialog.setContentText("Текущий файл изменен. Сохранить изменения?");

            Optional<ButtonType> result = alertDialog.showAndWait();
            if (result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    this.saveFile();
                }
            }
        }
        textAreaSettings();
        this.workFile = null;
        this.textArea.setText("");
    }

    @FXML
    protected void setWrap() {
        this.isWrap = !this.isWrap;
        this.textArea.setWrapText(this.isWrap);
    }

    @FXML
    protected void textUndo() {
        textArea.undo();
    }

    @FXML
    protected void textRedo() {
        textArea.redo();
    }

    @FXML
    protected void textCopy() {
        textArea.copy();
    }

    @FXML
    protected void textCut() {
        textArea.cut();
    }

    @FXML
    protected void textPaste() {
        textArea.paste();
    }

    @FXML
    protected void findString() {
        int textLength = textArea.getText().length();
        if (textLength > 0) {
            int lastIdx = textArea.getText().length() - 1;
            int lastFoundIdx = textArea.getText().indexOf(textToFind.getText(), foundIdx, lastIdx);
            String alertHeader;
            String alertMessage;
            if (lastFoundIdx != -1) {
                textArea.selectPositionCaret(lastFoundIdx);
                if (toReplace.isSelected()) {
                    textArea.selectPositionCaret(lastFoundIdx);
                    textArea.replaceText(lastFoundIdx, lastFoundIdx + textToFind.getLength(), textToReplace.getText());
                    textArea.selectRange(lastFoundIdx, lastFoundIdx + textToReplace.getLength());
                    replaceCount++;
                } else {
                    textArea.selectRange(lastFoundIdx, lastFoundIdx + textToFind.getLength());
                }
            } else {
                if (replaceCount == 0) {
                    alertHeader = "Совпадений нет!";
                    alertMessage = "Совпадений не найдено!";
                } else {
                    alertHeader = "Больше совпадений нет!";
                    alertMessage = String.format("Больше совпадений не найдено!\nПроизведено %d замен", replaceCount);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(alertHeader);
                alert.setHeaderText(alertMessage);
                alert.showAndWait();
                replaceCount = 0;
                docIsEnded = true;
            }
            foundIdx = lastFoundIdx + 1;
        }
    }

    @FXML
    private void replaceStringsAll() {
        docIsEnded = false;
        foundIdx = 0;
        while (!docIsEnded) {
            findString();
        }
    }

    @FXML
    public void infoMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("""
                Программа написана студентом ТУСУР кафедры АОИ
                направления подготовки 09.03.04
                группы з-423П8-1 Шестериным Алексеем,
                январь 2025.
                """);
        alert.setContentText("""
                Использованы технологии:
                OpenJDK 21
                JavaFX 21
                Maven 3.9
                """);
        alert.showAndWait();
    }

    protected KeyCombination kFNew = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kFOpen = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kFSave = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kFSaveAs = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
    protected KeyCombination kEUndo = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kERedo = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
    protected KeyCombination kECopy = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kECut = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kEPaste = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kEFind = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);
    protected KeyCombination kSWrap = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
}

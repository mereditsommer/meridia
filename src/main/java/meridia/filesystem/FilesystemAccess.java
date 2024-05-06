package meridia.filesystem;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilesystemAccess {
    static final FileChooser fileChooser = new FileChooser();
    private static Desktop desktop = Desktop.getDesktop();
    public static File readFile(Stage stage){
        System.out.println("filesystem class");
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }

    private static void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

}

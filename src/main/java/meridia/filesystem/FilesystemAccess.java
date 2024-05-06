package meridia.filesystem;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class FilesystemAccess {
    private static Class className  =  FilesystemAccess.class;
    static final FileChooser fileChooser = new FileChooser();
    private static Desktop desktop = Desktop.getDesktop();
    public static File readFile(Stage stage){
        System.out.println("filesystem class");
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }

    public static void downloadImage(Stage stage, PresentationModel model){

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                try {
                    BufferedImage buffer = ImageIO.read(
                            FilesystemAccess.className.getResource("/meredia.png"));
                    ImageIO.write(buffer, "png", file);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
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

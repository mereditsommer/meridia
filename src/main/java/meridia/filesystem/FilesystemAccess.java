package meridia.filesystem;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import meridia.presentationmodels.PresentationModel;
import meridia.utils.Filters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FilesystemAccess {
    static final FileChooser fileChooser = new FileChooser();
    private static final Desktop desktop = Desktop.getDesktop();

    public static File readFile(Stage stage) {
        configureFileChooser();
        return fileChooser.showOpenDialog(stage);
    }

    public static void downloadImage(Stage stage, PresentationModel model) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        String[] fileNameParts = model.getFile().getName().split("\\.");
        String name = fileNameParts[0];
        String format = fileNameParts[1];
        fileChooser.setInitialFileName(name + "_meridia-" + Filters.getExtension(model.getActiveFilter()) + "." + format);
        File file = fileChooser.showSaveDialog(stage);
        URL imageURL = FilesystemAccess.class.getResource("/meridia." + format);
        if (file != null && imageURL != null) {
            try {
                BufferedImage buffer = ImageIO.read(imageURL);
                ImageIO.write(buffer, format, file);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void configureFileChooser() {
        FilesystemAccess.fileChooser.setTitle("View Pictures");
        FilesystemAccess.fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        List<String> extList = new ArrayList<>();
        extList.add("*.jpg");
        extList.add("*.png");
        FilesystemAccess.fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG or PNG", extList)
        );
    }

}

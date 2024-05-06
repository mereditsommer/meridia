package meridia.presentationmodels;

import meridia.utils.Filter;
import meridia.utils.Filters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PresentationModel {

    private File file;

    public PresentationModel() throws IOException {

    }

    public void setFilter(Filter filter) {
        switch (filter) {
            case BW -> Filters.setBlackWhiteFilter(file);
            case GRAY -> Filters.setGrayscaleFilter(file);
            case PIXEL -> Filters.setPixelFilter(file);
        }
    }

    public void upload() {

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

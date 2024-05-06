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

    BufferedImage img;

    public PresentationModel() throws IOException {
        URL filePath = getClass().getResource("../hongkong.jpg");
        img = ImageIO.read(filePath);
    }

    public void setFilter(Filter filter) {
        switch (filter) {
            case BW -> Filters.setBlackWhiteFilter(img);
            case GRAY -> Filters.setGrayscaleFilter(img);
            case PIXEL -> Filters.setPixelFilter(img);
        }
    }

    public void upload() {


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private File file;
    public void setFilter() {

    }


}

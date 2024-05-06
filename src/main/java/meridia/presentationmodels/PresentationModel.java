package meridia.presentationmodels;

import meridia.utils.Filter;
import meridia.utils.Filters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
    }
}

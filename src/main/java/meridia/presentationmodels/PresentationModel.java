package meridia.presentationmodels;

import meridia.utils.Filter;
import meridia.utils.Filters;

import java.io.IOException;
import java.io.File;

public class PresentationModel {

    private File file;

    public void setFilter(Filter filter) {
        try {
        switch (filter) {
            case BW -> Filters.setBlackWhiteFilter(file);
            case GRAY -> Filters.setGrayscaleFilter(file);
            case PIXEL -> Filters.setPixelFilter(file);
        }
        } catch (IOException ex) {
            System.out.println("cannot read file");
            System.out.println(ex.getMessage());
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

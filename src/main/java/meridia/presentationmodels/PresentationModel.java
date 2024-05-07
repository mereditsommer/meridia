package meridia.presentationmodels;

import meridia.utils.Filter;
import meridia.utils.Filters;
import meridia.views.ImageProcessorView;

import java.io.IOException;
import java.io.File;

public class PresentationModel {

    private ImageProcessorView imageProcessorView;
    private File file;
    private Filter activeFilter;

    public void setFilter(Filter filter) {
        if (filter == Filter.NONE) {
            this.imageProcessorView.resetImage();
            return;
        }
        try {
            switch (filter) {
                case BW -> Filters.setBlackWhiteFilter(file);
                case GRAY -> Filters.setGrayscaleFilter(file);
                case PIXEL -> Filters.setPixelFilter(file);
            }
            this.activeFilter = filter;
            this.imageProcessorView.setImageWithFilter();
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

    public void setImageProcessorView(ImageProcessorView imageProcessorView) {
        this.imageProcessorView = imageProcessorView;
    }

    public Filter getActiveFilter() {
        return activeFilter;
    }
}

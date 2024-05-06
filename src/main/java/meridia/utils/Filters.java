package meridia.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Filters {
    public static void setBlackWhiteFilter(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        for (int w = 0; w < img.getWidth(); w++) {
            for (int h = 0; h < img.getHeight(); h++) {
                Color color = new Color(img.getRGB(w, h));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                // lightness is the average of the largest and smallest color components
                Color newColor;
                int max = Math.max(r, Math.max(g, b));
                int min = Math.min(r, Math.min(g, b));
                // lightness is the average of the largest and smallest color components
                int lum = (max + min) / 2;
                if (lum > 127) {
                    newColor = Color.WHITE;
                } else {
                    newColor = Color.BLACK;
                }
                img.setRGB(w, h, newColor.getRGB());
            }
        }
        writeFile(img, file);
    }

    public static void setGrayscaleFilter(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        for (int w = 0; w < img.getWidth(); w++) {
            for (int h = 0; h < img.getHeight(); h++) {
                Color color = new Color(img.getRGB(w, h));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int max = Math.max(r, Math.max(g, b));
                int min = Math.min(r, Math.min(g, b));
                // lightness is the average of the largest and smallest color components
                int lum = (max + min) / 2;
                Color newColor = new Color(lum, lum, lum);
                img.setRGB(w, h, newColor.getRGB());
            }
        }
        writeFile(img, file);
    }

    public static void setPixelFilter(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);

        writeFile(img, file);
    }

    private static String getFormat(File file) {
        return file.getName().split("\\.")[1];
    }

    private static void writeFile(BufferedImage img, File file) throws IOException {
        String format = Filters.getFormat(file);
        URL resourceUrl = Filters.class.getResource("/");
        if (resourceUrl == null) {
            throw new IOException("Resource directory not found.");
        }
        String resourcePath = resourceUrl.getPath();
        String filePath = resourcePath + "meridia." + format;
        File target = new File(filePath);
        ImageIO.write(img, format, target);
    }
}

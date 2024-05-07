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
                int max = Math.max(r, Math.max(g, b));
                int min = Math.min(r, Math.min(g, b));
                // lightness is the average of the largest and smallest color components
                int lum = (max + min) / 2;
                Color newColor;
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
        int pixelSize = 10;
        BufferedImage img = ImageIO.read(file);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y += pixelSize) {
            for (int x = 0; x < width; x += pixelSize) {
                Color pixelColor = getAverageColor(img, x, y, pixelSize);
                for(int yd = y; (yd < y + pixelSize) && (yd < height); yd++) {
                    for(int xd = x; (xd < x + pixelSize) && (xd < width); xd++) {
                        img.setRGB(xd, yd, pixelColor.getRGB());
                    }
                }
            }
        }
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

    private static Color getAverageColor(BufferedImage image, int startX, int startY, int size) {
        int totalRed = 0, totalGreen = 0, totalBlue = 0;
        int pixelCount = 0;

        for (int y = startY; y < startY + size && y < image.getHeight(); y++) {
            for (int x = startX; x < startX + size && x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                totalRed += (rgb >> 16) & 0xFF;
                totalGreen += (rgb >> 8) & 0xFF;
                totalBlue += rgb & 0xFF;
                pixelCount++;
            }
        }

        int avgRed = totalRed / pixelCount;
        int avgGreen = totalGreen / pixelCount;
        int avgBlue = totalBlue / pixelCount;

        return new Color(avgRed, avgGreen, avgBlue);
    }
}

package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlurYamamoto{
    public static void main(String[] args){
        File file = new File(args[0]);
        int pixelSize = Integer.parseInt(args[1]);
        try {
            BufferedImage readImage = ImageIO.read(file);
            int width = readImage.getWidth();
            int height = readImage.getHeight();

            BufferedImage writeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for(int i = 0; i < width; i += pixelSize){
                for(int j = 0; j < height; j += pixelSize){
                    int sumR = 0, sumG = 0, sumB = 0;
                    for(int x = i; x < Math.min(width, i + pixelSize); x++){
                        for(int y = j; y < Math.min(height, j + pixelSize); y++){
                            Color color = new Color(readImage.getRGB(x, y));
                            sumR += color.getRed();
                            sumG += color.getGreen();
                            sumB += color.getBlue();;
                        }
                    }
                    int pixelNumber = Math.min(width - i, pixelSize) * Math.min(height - j, pixelSize);
                    int average = new Color(sumR / pixelNumber, sumG / pixelNumber, sumB / pixelNumber).getRGB();

                    for(int x = i; x < Math.min(width, i + pixelSize); x++){
                        for(int y = j; y < Math.min(height, j + pixelSize); y++){
                            writeImage.setRGB(x, y, average);
                        }
                    }
                }
            }
            ImageIO.write(writeImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
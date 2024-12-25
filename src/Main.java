import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (args.length != 1 || !args[0].toLowerCase().endsWith(".webp")) {
            System.out.println("Using: java WebpToPngConverter <input_file.webp>");
            return;
        }

        String inputPath = args[0];
        String outputPath = inputPath.substring(0, inputPath.toLowerCase().lastIndexOf(".webp")) + ".png";

        try {
            BufferedImage webpImage = ImageIO.read(new File(inputPath));
            if (webpImage == null) {
                System.out.println("Unable to read WebP file.");
                return;
            }

            boolean result = ImageIO.write(webpImage, "png", new File(outputPath));
            if (result) {
                System.out.println("Done: " + outputPath);
            } else {
                System.out.println("Unable to write PNG file.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
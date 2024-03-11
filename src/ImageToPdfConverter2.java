import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToPdfConverter2 {

    public static void main(String[] args) {
        try {
            String[] imagePaths = {"C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\page 1.jpeg"
              , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\page 2.png"
              , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\page 3.jpeg"
              , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\page 4.jpeg"
              , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\page 5.jpeg"};
            String outputPdfPath = "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\output.pdf";

            mergeImagesToPdf(imagePaths, outputPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeImagesToPdf(String[] imagePaths, String outputPdfPath) throws IOException {
        PDDocument document = new PDDocument();

        for (String imagePath : imagePaths) {
            BufferedImage image = ImageIO.read(new File(imagePath));
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImageXObject, 0, 0);
            contentStream.close();
        }

        document.save(outputPdfPath);
        document.close();
    }
}

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToPDFConverter {

    public static void main(String[] args) {
        try {
            // Specify the path to the images and the output PDF file
            String[] imagePaths = {"C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\1.png"
                    , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\2.png"
                    , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\3.png"
                    , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\4.png"
                    , "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\5.png"};
            String outputPdfPath = "C:\\Users\\ravi\\IdeaProjects\\JavaCoreAlgorithmCoding\\output3.pdf";

            // Create a new PDF document
            PDDocument document = new PDDocument();

            for (String imagePath : imagePaths) {
                // Load each image
                BufferedImage image = ImageIO.read(new File(imagePath));

                // Create a new in the PDF document
                PDPage page = new PDPage();
                document.addPage(page);

                // Create content stream for the page
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                // Scale the image to fit the page
                float scale = 0.72f; // Adjust the scale factor as needed
                contentStream.drawImage(PDImageXObject.createFromFile(imagePath, document), 20, 20, image.getWidth() * scale, image.getHeight() * scale);

                // Close the content stream
                contentStream.close();
            }

            // Save the document to a file
            document.save(outputPdfPath);

            // Close the document
            document.close();

            System.out.println("PDF created successfully at: " + outputPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Croper {
    static String directory = "/Users/chriscui/Downloads/0301/";
    static String hotDirectory = directory+"hot/";

    static String outputDirectory = directory.concat("output");

    public static void main(String[] args) throws IOException {
        File folder = new File(directory);
        File hotfolder = new File(hotDirectory);

//create output folder
        File output = new File(outputDirectory);
        if (! output.exists()){
            output.mkdir();
        }



        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
            } else if(fileEntry.getName().endsWith(".pdf")) {
                System.out.println(fileEntry.getName());
                PDDocument doc = PDDocument.load(fileEntry);
                PDPage page = doc.getPage(0);
                page.setCropBox(new PDRectangle(88, 495, 420, 275));
                doc.save(outputDirectory +"/"+fileEntry.getName());
                doc.close();
            }else{
                System.out.println("extra file:"+fileEntry.getName());
            }
        }

//        for (final File fileEntry : folder.listFiles()) {
//            if (fileEntry.isDirectory()) {
////                listFilesForFolder(fileEntry);
//            } else if(fileEntry.getName().endsWith(".pdf")) {
//                System.out.println(fileEntry.getName());
//                PDDocument doc = PDDocument.load(fileEntry);
//                PDPage page = doc.getPage(0);
//                page.setCropBox(new PDRectangle(50, 420, 520, 350));
//                doc.save(outputDirectory +"/"+fileEntry.getName());
//                doc.close();
//            }else{
//                System.out.println("extra file:"+fileEntry.getName());
//            }
//        }

        if(hotfolder.exists()){
            for (final File fileEntry : hotfolder.listFiles()) {
                if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
                } else if(fileEntry.getName().endsWith(".pdf")) {
                    PDDocument doc = PDDocument.load(fileEntry);
                    PDPage page = doc.getPage(0);
                    page.setCropBox(new PDRectangle(160, 320, 295, 440));
                    doc.save(outputDirectory +"/"+fileEntry.getName());
                    doc.close();
                }else{
                    System.out.println("extra file:"+fileEntry.getName());
                }
            }
        }



//        File file = new File("/Users/chriscui/Downloads/20211201/2019-1,.pdf");
//        PDDocument doc = PDDocument.load(file);
//        PDPage page = doc.getPage(0);
//        page.setCropBox(new PDRectangle(50, 420, 520, 350));
//        doc.save(outputDirectory +"/"+file.getName());
//        doc.close();

//        File file = new File("/Users/chriscui/Downloads/20211201/hot/2017~3卷.pdf");
//        PDDocument doc = PDDocument.load(file);
//        PDPage page = doc.getPage(0);
//        page.setCropBox(new PDRectangle(160, 320, 295, 440));
//        doc.save(outputDirectory +"/"+file.getName());
//        doc.close();
    }
}

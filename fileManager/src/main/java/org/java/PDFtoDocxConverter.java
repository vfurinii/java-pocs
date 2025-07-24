package org.java;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileOutputStream;

public class PDFtoDocxConverter {
    public static void main(String[] args) throws Exception {
    // carrega o PDF
    PDDocument document = PDDocument.load(new File("C:\\Users\\vitor\\Desktop\\teste.pdf"));
    PDFTextStripper stripper = new PDFTextStripper();
    String texto = stripper.getText(document);
    document.close();


    //cria o documento em formato docx
    XWPFDocument docx = new XWPFDocument();
    XWPFParagraph paragrafo = docx.createParagraph();
    paragrafo.createRun().setText(texto);

    //salva
    FileOutputStream out = new FileOutputStream("C:\\Users\\vitor\\Desktop\\arquivo_convertido.docx");
    docx.write(out);
    out.close();
    docx.close();

    System.out.println("Arquivo convertido com sucesso!");
    }
}

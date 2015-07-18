package com.jschaf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFA;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("usage: java <input-file>");
            System.exit(1);
        }

        String filename = args[0];
        PDDocument document = PDDocument.load(new File(filename));
        document.setAllSecurityToBeRemoved(true);

        if (document.isEncrypted()) {
            try {
                document.decrypt("");
                document.setAllSecurityToBeRemoved(true);
            }
            catch (Exception e) {
                throw new Exception("The document is encrypted and we can't decrypt it");
            }
        }

        PDDocumentCatalog documentCatalog = document.getDocumentCatalog();
        PDAcroForm form = documentCatalog.getAcroForm();

        PDXFA xfa = form.getXFA();

        System.out.println(xfa.toString());


    }

    public void openFile() {

    }
}

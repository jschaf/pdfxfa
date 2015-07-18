package com.jschaf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;

import static org.junit.Assert.*;

public class MainTest {

        @org.junit.Test
        public void testMain() throws Exception {

            File file = new File("pdf/da1059.pdf");
            PDDocument document = PDDocument.load(file);
            document.setAllSecurityToBeRemoved(true);
            assertTrue("da1059.pdf is encrypted.", document.isEncrypted());
        }

}
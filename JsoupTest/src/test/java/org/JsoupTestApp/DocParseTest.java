package org.JsoupTestApp;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocParseTest {

    //
    @Test
    public void TestValidParseConnection() {
        DocParse docParse = new DocParse();
        try {
            docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        }
        catch(Exception e) {
            fail("Error should not have been thrown a valid url has been sent.");
        }
    }

    //Che
    @Test
    public void TestInvalidParseConnection() {
        DocParse docParse = new DocParse();
        try {
            docParse.ParseConnection("invalidUrl.testfail");
            fail("Error should have been thrown");
        }
        catch(Exception e) {
            return;
        }
    }

    @Test
    public void TestParseElement() {
        DocParse docParse = new DocParse();
        docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        docParse.ParseElement();
        assertNotNull(docParse.heading);
        assertNotNull(docParse.author);
        assertNotNull(docParse.content);
    }

    @Test
    public void TestContentsToString() {
        DocParse docParse = new DocParse();
        docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        docParse.ParseElement();
        docParse.ContentsToString();
        assertNotNull(docParse.poemArray);
    }

    @Test
    public void TestConvertArrayToList() {
        DocParse docParse = new DocParse();
        docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        docParse.ParseElement();
        docParse.ContentsToString();
        docParse.ConvertArrayToList();
        assertNotNull(docParse.poemText);
    }

    @Test
    public void TestGetWordFrequencyFromList() {
        DocParse docParse = new DocParse();
        docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        docParse.ParseElement();
        docParse.ContentsToString();
        docParse.ConvertArrayToList();
        docParse.GetWordFrequencyFromList();
        assertNotNull(docParse.poemText);
    }
}
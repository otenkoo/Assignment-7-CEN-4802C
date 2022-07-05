package org.JsoupTestApp;

public class App {
    public static void main(String[] args) {
        DocParse docParse = new DocParse();
        //Adding a test comment to test the git commit again
        System.out.println();

        //Input url here to parse web page
        docParse.ParseConnection("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        docParse.ParseElement();
        System.out.println();

        docParse.ContentsToString();
        docParse.ConvertArrayToList();
        docParse.GetWordFrequencyFromList();


    }
}

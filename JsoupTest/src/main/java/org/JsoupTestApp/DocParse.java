package org.JsoupTestApp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;

public class DocParse {
    Document doc;
    String poem;
    String heading;
    String author;
    String content;
    String poemArray[];
    List<String> poemText;

    // Download the URL and parse it into a Document object.
    public void ParseConnection(String url) {
        System.out.println("Parsing URL...");
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Parse specific element from the Document object.
    public void ParseElement() {
        System.out.println("Parsing Elements...");
        Elements heading = doc.select("h1");
        Elements author = doc.select("h2.no-break");
        Elements content = doc.select("div.chapter");

        this.heading = heading.text();
        this.author = author.text();
        this.content = content.text();
    }

    // Consolidate all elements into 1 string and remove HTML code with .text()
    // appendage.
    // Store string into array making all lower case and removing all
    // non-alphabetical characters
    public void ContentsToString() {
        String poem = heading + " " + author + " " + content;
        poemArray = poem.toUpperCase().split("\\W+");
    }

    //Converts standard array into an array list.
    public void ConvertArrayToList() {
        poemText = Arrays.asList(poemArray);
    }

    //Print out array list of the top 20 most used words from poemText using hashmap.
    public void GetWordFrequencyFromList() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : poemText) {
            Integer count = map.get(word);
            map.put(word, (count == null) ? 1 : count + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : list.subList(0, 20)) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


}

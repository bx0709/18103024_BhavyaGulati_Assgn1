/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;

import com.opencsv.CSVWriter;
import org.jsoup.UnsupportedMimeTypeException;
import java.net.*;

public class FocWebCrawl1 {
    
    
    public static boolean valid(String url)
    {
        try {
            new URL(url).toURI();

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private static final List<String> related_Words= new LinkedList<>();

    public static boolean is_related(String link) {
        for(String s : related_Words)
        {
            if(link.contains(s) ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        print("Running...");
        
        Set<String> allfiles = new HashSet<String>();
        
        Queue<String> links = new LinkedList<>();
        Set<String> links_set = new HashSet<String>();
        
        int count=0;
        Document document = null;
        links.add("https://pec.ac.in/");
        
        related_Words.addAll(Arrays.asList(("faculty professor prof qualification director phd assistant teacher teaching scholar chairman").split(" ")));

        try {
            FileOutputStream fout1 = new FileOutputStream("links.csv");        
            CSVWriter csv = new CSVWriter(new FileWriter(new File("links.csv")));
        
            FileOutputStream fout2 = new FileOutputStream("objects.csv");        
            CSVWriter csv_1 = new CSVWriter(new FileWriter(new File("objects.csv")));
        
            csv.writeNext(new String[] {"Link", "Text", "Paragraphs"});
            csv_1.writeNext(new String[] {"Object Link", "Text"});
        
            Iterator<String> it = links.iterator();
        
            while (it.hasNext()) {
                String first_link=links.remove();
                try {
                    document = Jsoup.connect(first_link).get();
                    if (is_related(first_link)) {
                        Elements paras = document.select("p");
                        String allparas = "";
                        for(Element str : paras) {
                            allparas += str.text();
                        }
                        count++;
                        System.out.println(count+ " " + first_link);
                        csv.writeNext(new String[] {first_link,document.title(),allparas});

                    }
                    Elements elinks = document.select("a[href]");        
                    for (Element link : elinks) {
                        String tlink = link.attr("abs:href");
                        if (valid(tlink)) {
                            if (tlink.startsWith("https://pec.ac.in/") && !(tlink.contains("#"))) {
                                if (!links_set.contains(tlink)) {
                                    try {
                                        Jsoup.connect(tlink).get();
                                        links.add(tlink);
                                    } catch(UnsupportedMimeTypeException type) {
                                        allfiles.add(tlink + link.text() + "\r\n");
                                        csv_1.writeNext(new String[] { tlink, link.text()});
                                    }

                                }
                                links_set.add(tlink);
                            }
                        }
                    }
                    System.out.println(links);
                    if (count == 800)
                        break;
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        print("done");
    }
    
    public static void print(String string) {
	System.out.println(string);
    }
    
}

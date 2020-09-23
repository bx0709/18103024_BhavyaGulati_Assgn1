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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JSoupScrape {
    public static void main(String args[]){
	print("running...");
        Document document = null;
        try{
            document = Jsoup.connect("https://pec.ac.in/").get();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        try{
            FileWriter my_writer = new FileWriter("AllHomePageData.txt");
            my_writer.write(document.toString());
            my_writer.close();
            print("Write to main file successfull.");
        } catch(IOException ioe){
            print("Error found.");
            ioe.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet spreadsheet = wb.createSheet("pTags");
        XSSFRow row;
        int rnum=0;
        Elements ptags = document.getElementsByTag("p");
        for(Element tag:ptags){
            String s = tag.text();
            if(s.length()>1){
                row = spreadsheet.createRow(rnum++);
                Cell c = row.createCell(0);
                c.setCellValue("<p>");
                c = row.createCell(1);
                c.setCellValue(tag.text());
                c = row.createCell(2);
                c.setCellValue("</p>");
            }
        }
        print("Paragraph Tags Done.");
        
        XSSFSheet spreadsheet2 = wb.createSheet("aTags");
        int rnum1 = 0;
        Elements atags = document.select("a[href]");
        for(Element tag:atags){
            String s = tag.text();
            if(s.length()>1){
                row = spreadsheet2.createRow(rnum1++);
                Cell c = row.createCell(0);
                String s1 = tag.text();
                if(s1.length()>0){
                    c.setCellValue(s1);
                }
                else{
                    c.setCellValue("---");
                }
                c = row.createCell(1);
                c.setCellValue(tag.absUrl("href"));
            }
        }
        print("Anchor Tags Done.");
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(new File("Scrapping.xlsx"));
        } catch(Exception e){
            print("File already exists.");
        }
        if(out!=null){
            try{
                wb.write(out);
                out.close();
                print("Process Complete.");
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        
    }


	public static void print(String string) {
		System.out.println(string);
	}
}

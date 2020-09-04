/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    
    public String replaceWords(String para, String[] words){
        if(para == null || para.length() < 1)
            return null;
        if(words == null || words.length < 1)
            return para;
        
        StringBuilder sub;
        for(String word: words){
            sub = new StringBuilder();
            sub.append(word.charAt(0));
            for(int i=0; i<word.length()-1; ++i)
                sub.append('*');
            
            para = para.replaceAll(word, sub.toString());
        }
        
        return para;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter paragraph: ");
        String paragraph = sc.nextLine();
        
        System.out.println("Enter number of words to be replaced: ");
        int size = sc.nextInt();
        
        sc.nextLine();
        String[] words = new String[size];
        
        System.out.println("Enter words: ");
        for(int i=0; i<size; ++i){
            words[i] = sc.nextLine();
        }

        System.out.println((new Question2()).replaceWords(paragraph, words));
    }
    
}

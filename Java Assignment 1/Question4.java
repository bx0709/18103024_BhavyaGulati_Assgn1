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

import java.io.*; 
import java.util.Arrays; 
import java.util.Collections;
import java.util.Scanner;
  
class Question4 { 
  
    
    static boolean isAnagram(String str1, String str2) 
    { 
         
        int n = str1.length(); 
        int m = str2.length(); 
        if (n != m){
            return false;
        }
            
        char first[] = str1.toCharArray();
        Arrays.sort(first);
        
        char second[] = str2.toCharArray();
        Arrays.sort(second);
         
        for (int i = 0; i < n; i++){ 
            if (first[i] != second[i]){ 
                return false; 
            }
        }
  
        return true; 
    } 
  
    
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first string: ");
        String str1 = sc.nextLine();
        
        System.out.println("Enter second string: ");
        String str2 = sc.nextLine();
        
        if (isAnagram(str1, str2)) 
            System.out.println("The two strings are anagram of each other"); 
        else
            System.out.println("The two strings are not anagram of each other"); 
    } 
}
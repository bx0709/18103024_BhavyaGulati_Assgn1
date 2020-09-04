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
import java.util.Arrays;
import java.util.Scanner;

public class Question2_1 {
    public static int compare(String a,String b){
        for(int i=0;i<a.length() && i<b.length();i++){
            if((int)a.charAt(i)!=(int)b.charAt(i)){
                return (int)a.charAt(i) - (int)b.charAt(i);
            }
        }
        
        if(a.length()<b.length()){
            return a.length()-b.length();
        }
        else{
            return b.length()-a.length();
        }
    }
    
    static public void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter 1st string: ");
        String str1 = sc.nextLine();
        
        System.out.println("Enter 2nd string: ");
        String str2 = sc.nextLine();         
        
        System.out.println(compare(str1, str2));         
    }
}

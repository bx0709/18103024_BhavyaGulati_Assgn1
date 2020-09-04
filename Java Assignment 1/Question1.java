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

class Question1 {
	static int Question1(String needle, String haystack) {         
        int M = needle.length();         
        int N = haystack.length();         
        int res = 0; 
        
        if(N-M<0){
            return 0;
        }
        
        char needle_arr[] = needle.toCharArray();
        Arrays.sort(needle_arr);
        String Needle = new String(needle_arr);
       
        for (int i = 0; i <= N - M; i++) { 
            char hay_arr[] = haystack.substring(i, i+M).toCharArray();
            Arrays.sort(hay_arr);
            String hay = new String(hay_arr);
            int j = 0;
            for(j=0;j<M;j++){
                if (hay.charAt(j)!=Needle.charAt(j)) { 
                    break;
                }
            }
            
            if(j==M){
                res++;
                j=0;
            }
            
        }         
        return res;         
    } 
  
    
    static public void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the string");
        String haystack = sc.nextLine();
        
        System.out.println("enter the substring");
        String needle = sc.nextLine();         
        
        System.out.println(Question1(needle, haystack));         
    } 
}

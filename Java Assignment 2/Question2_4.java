/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.*;
import java.io.*;


public class Question2_4 {
    public static void main(String[] args){
        long nsum = 1;
        long n = 1;
        while(n<=Integer.MAX_VALUE){
            if(nsum==n*n){
                System.out.println(n);
            }
            n++;
            nsum+=n;
        }
    }
}

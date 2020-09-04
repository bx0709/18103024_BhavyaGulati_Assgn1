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


class Question2_6{
    static int i; 
    
    static int Question6(int n){
        System.out.print(n+" ");
        if(n==1&&i==0){
            return i;
        }
        if(n==1 && i!=0){
            i++;
            return i;
        }
        if(n%2==0){
            i++;
            Question6(n/2);
        }
        else if(n%2!=0){
            i++;
            Question6(3*n+1);
        }
        return i;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value: ");
        int n = sc.nextInt();
        int x = Question6(n);
        System.out.println("Number of steps = "+x);
    }
}

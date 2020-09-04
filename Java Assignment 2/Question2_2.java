/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.Arrays;
import java.util.Scanner;

public class Question2_2 {
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        int[] count = new int[21];
        for(int i=0; i<21; i++){
            count[i]=0;
	}
	System.out.println("Enter number of elements: ");
	int len = sc.nextInt();
	for(int i=0; i<len; i++){
            System.out.println("Enter Value: ");
            int x = sc.nextInt();
            count[x]++;
	}
	System.out.println("Sorted Array (ascending order): ");
	for(int i=0; i<21; i++){
            while(count[i] > 0){
                System.out.println(i+" ");
                count[i]--;
	    }
	}
    }


}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class CountThread extends Thread {
        public void run() {
            for(int i = 1;i<=100;++i) {
                System.out.print(i + " ");
                if(i % 10 == 0)
                    System.out.println("Hello World!");
                try {
                    Thread.sleep(1000);
                    } catch(InterruptedException e) {}
            }
        }
        public static void main(String [] args) {
            new CountThread().start();
        }
}

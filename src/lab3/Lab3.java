/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Yasiru Randeepa
 */
public class Lab3 {

   
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException{
        
        float riderArrivalMeanTime = 3f * 1000;
        float busArrivalMeanTime = 2 * 60f * 1000 ;
        

        riderGenerator riderGenerator = new riderGenerator(riderArrivalMeanTime);
        (new Thread(riderGenerator)).start();

        busGenerator busGenerator = new busGenerator(busArrivalMeanTime);
        (new Thread(busGenerator)).start();

    }

    
}

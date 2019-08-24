/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Random;

/**
 *
 * @author Yasiru Randeepa
 */
public class busGenerator extends Thread{
    
    private float arrivalMeanTime;
    private static Random random;

    public busGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }

    @Override
    public void run() {


        // Spawning bus threads for the user specified value
        while (!Thread.currentThread().isInterrupted()) {

            try {
                // Sleeping the thread to obtain the inter arrival time between the bus threads
                Thread.sleep(getExponentiallyDistributedBusInterArrivalTime());
                // Initializing and starting the bus threads
                bus b = new bus();
                System.out.println("Bus " + b.getBus() + " Arrived");
                (new Thread(b)).start();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to get the exponentially distributed bus inter arrival time
    public long getExponentiallyDistributedBusInterArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}

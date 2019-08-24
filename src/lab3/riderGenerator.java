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
public class riderGenerator extends Thread {
    
    private float arrivalMeanTime;
    private static Random random;

    public riderGenerator(float arrivalMeanTime) {
        this.arrivalMeanTime = arrivalMeanTime;
        random = new Random();
    }
    
    @Override
    public void run() {

        // Spawning rider threads for the user specified value
        while (!Thread.currentThread().isInterrupted()) {

            try {
                // Initializing and starting the rider threads
                rider r = new rider();
                (new Thread(r)).start();

                // Sleeping the thread to obtain the inter arrival time between the threads
                Thread.sleep(getExponentiallyDistributedRiderInterArrivalTime());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getExponentiallyDistributedRiderInterArrivalTime() {
        float lambda = 1 / arrivalMeanTime;
        return Math.round(-Math.log(1 - random.nextFloat()) / lambda);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Yasiru Randeepa
 */
public class resources {
    
    private static int riderCount = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore multiplex = new Semaphore(50);
    private static Semaphore bus = new Semaphore(0);
    private static Semaphore allAboard = new Semaphore(0);

    /**
     * @return the mutex
     */
    public static Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param aMutex the mutex to set
     */
    public static void setMutex(Semaphore aMutex) {
        mutex = aMutex;
    }

    /**
     * @return the multiplex
     */
    public static Semaphore getMultiplex() {
        return multiplex;
    }

    /**
     * @param aMultiplex the multiplex to set
     */
    public static void setMultiplex(Semaphore aMultiplex) {
        multiplex = aMultiplex;
    }

    /**
     * @return the bus
     */
    public static Semaphore getBus() {
        return bus;
    }

    /**
     * @param aBus the bus to set
     */
    public static void setBus(Semaphore aBus) {
        bus = aBus;
    }

    /**
     * @return the allAboard
     */
    public static Semaphore getAllAboard() {
        return allAboard;
    }

    /**
     * @param aAllAboard the allAboard to set
     */
    public static void setAllAboard(Semaphore aAllAboard) {
        allAboard = aAllAboard;
    }

    /**
     * @return the riderCount
     */
    public static int getRiderCount() {
        return riderCount;
    }

    /**
     * @param aRiderCount the riderCount to set
     */
    public static void setRiderCount(int aRiderCount) {
        riderCount = aRiderCount;
    }
    
    
}

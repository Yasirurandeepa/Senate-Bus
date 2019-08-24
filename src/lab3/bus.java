/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Yasiru Randeepa
 */
public class bus extends Thread{
    
    resources r;
    rider riders;
    private static int bus = 0;
    
    public bus (){
      
    }

    @Override
    public void run() {
        try{
            r.getMutex().acquire();
            if (riders.getRiders()>0){
                r.getBus().release();
                r.getAllAboard().acquire();
            }
            r.getMutex().release();
            setBus(getBus() + 1);
            System.out.println("Bus " + getBus() + " Departed");
        }catch(Exception e){
            
        }
    }

    /**
     * @return the bus
     */
    public static int getBus() {
        return bus;
    }

    /**
     * @param aBus the bus to set
     */
    public static void setBus(int aBus) {
        bus = aBus;
    }

    
    
   
}

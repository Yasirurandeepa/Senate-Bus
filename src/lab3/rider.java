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
public class rider extends Thread{
    
    resources r;
    private static int riders = 0;
    
    public rider(){
     
    }

    @Override
    public void run() {
        try{
            r.getMultiplex().acquire();
            r.getMutex().acquire();
            setRiders(getRiders() + 1);
            System.out.println("Rider " + getRiders() + " Arrived");
            r.getMutex().release();
            
            r.getBus().acquire();
            r.getMultiplex().release();
            
            System.out.println("Rider " + getRiders() + " Boarded");
            
            setRiders(getRiders() - 1);
            if (getRiders()==0){
                r.getAllAboard().release();
            }else{
                r.getBus().release();
            }
            
        }catch(Exception e){
          
        }
    }

    /**
     * @return the riders
     */
    public static int getRiders() {
        return riders;
    }

    /**
     * @param aRiders the riders to set
     */
    public static void setRiders(int aRiders) {
        riders = aRiders;
    }

    
    
}

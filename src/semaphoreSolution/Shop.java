package semaphoreSolution;

import java.util.concurrent.Semaphore;

import base.ShopIF;

public class Shop implements ShopIF {
	
	   private final Semaphore availableSeats;
       private final Semaphore barberAvailable;
       private final Semaphore accessSeats;

       public Shop(int numberOfSeats) {
           availableSeats = new Semaphore(numberOfSeats);
           barberAvailable = new Semaphore(0);
           accessSeats = new Semaphore(1);
       }

       public boolean enter() {
           try {
               accessSeats.acquire();
               if (availableSeats.tryAcquire()) {
                   barberAvailable.release();
                   accessSeats.release();
                   return true;
               } else {
                   accessSeats.release();
                   return false;
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
               return false;
           }
       }

       public void leave() {
           try {
               availableSeats.release();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       public void waitForBarber() {
           try {
               barberAvailable.acquire();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
}

package semaphoreSolution;

import base.ShopIF;

public class Barber extends Thread {

    private ShopIF shop;

    public Barber(ShopIF shop) {
        this.shop = shop;
    }

    public void run() {
        while (true) {        	
            shop.waitForBarber();
//            try {
//				Thread.sleep((long) (Math.random()*1000));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
    }
}

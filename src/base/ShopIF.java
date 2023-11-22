package base;

import java.util.concurrent.Semaphore;

public interface ShopIF {

	boolean enter();

	void leave();
	
	void waitForBarber();	
}

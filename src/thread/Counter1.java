package thread;

class Increment {
    private static int count = 0;
    
    public static synchronized void increment() {
        count++;
    }
    
    public static int getCount() {
        return count;
    }
}

/**
 * Thread Join example
 * 
 */
public class Counter1 {
	

	public static void main(String[] args) throws InterruptedException {
    
		/*Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
            	Increment.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
            	Increment.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + Increment.getCount()); */
		
		Thread thread = new Thread(() -> {
            System.out.println("I'm running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I'm done!");
        });

        thread.start();

        // Wait for the thread to die
       // thread.join();

        System.out.println("The thread is dead.");
    }
}
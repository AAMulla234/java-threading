package thread;

public class ThreadDeadLock implements Runnable {

    int x, y; 
    public void run() 
    { 
        for(int i = 0; i < 1000; i++) 
            synchronized(this) 
            { 
                x = 12; 
                y = 12; 
            } 
        System.out.print(x + " " + y + " "); 
    } 
    public static void main(String args[]) 
    { 
    	ThreadDeadLock run = new ThreadDeadLock(); 
        Thread t1 = new Thread(run); 
        Thread t2 = new Thread(run); 
        t1.start(); 
        t2.start(); 
        
        String s1 = "abc";
		String s2 = "def";
			System.out.println("s1 == s2:" + s1 == s2);
			
			ThreadDeadLock var = null;
			System.out.println(ThreadDeadLock.class.isInstance(run));
			
			System.out.println(s1.compareTo(s2));

			
	} 
}
package thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Create a blocking queue with a capacity of 3
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Create producer and consumer threads
        Thread producer = new Thread(() -> {
            try {
                int value = 1;
                while (true) {
                    // Add elements to the queue
                    queue.put(value);
                    System.out.println("Produced: " + value);
                    value++;
                    Thread.sleep(1000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // Retrieve elements from the queue
                    int value = queue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(2000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        producer.start();
        consumer.start();

        // Wait for the threads to finish (this won't happen in this example as they run indefinitely)
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


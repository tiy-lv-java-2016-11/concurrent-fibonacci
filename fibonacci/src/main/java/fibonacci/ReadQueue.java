package fibonacci;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadQueue implements Runnable {
    private BlockingQueue<Integer> queue;
    private ExecutorService service = Executors.newFixedThreadPool(100);

    public ReadQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean done = false;
        int number;

        while(!done || !queue.isEmpty()){
            try {
                number = queue.take();
                System.out.printf("Sending number %d to Fibonacci\n", number);
                service.submit(new Fibonacci(number));
            } catch (InterruptedException e) {
                done = true;
            }
        }
        service.shutdown();
    }
}

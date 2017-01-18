package fibonacci;

import java.io.FileNotFoundException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

        Thread read = new Thread(new ReadFile(queue));
        Thread take = new Thread(new ReadQueue(queue));
        read.start();
        take.start();


//        read.interrupt();
    }
}

package fibonacci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by darionmoore on 1/17/17.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        Thread proThread = new Producer();
        proThread.start();
        service.submit(proThread);


    }
}

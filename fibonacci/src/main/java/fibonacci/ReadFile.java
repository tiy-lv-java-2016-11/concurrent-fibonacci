package fibonacci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReadFile implements Runnable {
    private BlockingQueue<Integer> queue;

    public ReadFile(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        File f = new File("fibdata.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()){
            Integer number = scanner.nextInt();
            System.out.printf("Queueing number %d\n", number);
            try {
                queue.put(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

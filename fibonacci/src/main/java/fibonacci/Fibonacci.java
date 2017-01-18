package fibonacci;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jeff on 6/28/16.
 */
public class Fibonacci implements Runnable{

    private Integer number;

    public Fibonacci(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("Starting the fibonacci of %d\n", this.number);
        long result = fib(this.number);
        System.out.printf("The fibonacci of %d is %d\n", this.number, result);
    }

    /**
     * Recursive fibonacci algorithm.  Majorly inefficient
     * @param number The nth number in the series to find
     * @return the long of the found number
     */
    public long fib(int number){

        long rval = 0;
        if(number < 1){
            rval = 0;
        }
        else if(number == 1){
            rval = 1;
        }
        else{
            rval = fib(number - 1) + fib(number - 2);
        }

        return rval;
    }

}

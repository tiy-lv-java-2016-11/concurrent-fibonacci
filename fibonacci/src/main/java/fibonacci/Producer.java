package fibonacci;

/**
 * Created by darionmoore on 1/17/17.
 */

/*
What is the problem?
Read in the provided numbers from the file, which represent the nth number in the Fibonacci sequence.
How?
Extend thread to implement runnable and get the number value from the fib variable
 */
public class Producer extends Thread{
    Fibonacci f = new Fibonacci(21);
    @Override
    public void run(){
        System.out.println("Nth number: " + f );
    }

}

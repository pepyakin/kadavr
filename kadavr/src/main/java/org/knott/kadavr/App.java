package org.knott.kadavr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public int fact(int n) {
        if (n <= 1) return 1;
        else {
            return fact(n - 1) * n;
        }
    }
}

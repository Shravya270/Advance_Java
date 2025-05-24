/*
 2.b. Develop a Java program to make a Performance Test on StringBuffer and StringBuilder for
appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify
your answer which one is better.
 */


public class PerformanceTest {
    public static void main(String[] args) {
        int iterations = 10000;

        // Test with StringBuffer (synchronized - thread-safe)
        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            buffer.append("AIET");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        // Test with StringBuilder (not synchronized - faster in single thread)
        StringBuilder builder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            builder.append("AIET");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: " + timeBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " nanoseconds");

        if (timeBuilder < timeBuffer) {
            System.out.println("StringBuilder is faster and more efficient for single-threaded operations.");
        } else {
            System.out.println("StringBuffer is better when thread safety is required.");
        }
    }
}

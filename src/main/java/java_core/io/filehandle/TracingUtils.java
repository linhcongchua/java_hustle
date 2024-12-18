package java_core.io.filehandle;

import java.util.function.Consumer;

public class TracingUtils {
    protected static <T> void proxyMethod(Consumer<T> consumer, T t, String methodName) {
        long startTime = System.nanoTime();
        consumer.accept(t);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[" + methodName + "]Logic execution time: " + duration + " nanoseconds");
    }

    protected static void proxyMethod(Runnable runnable, String methodName) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[" + methodName + "]Logic execution time: " + duration + " nanoseconds");
    }

    protected static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Current memory usage: " + usedMemory / (1024 * 1024) + " MB");
    }
}

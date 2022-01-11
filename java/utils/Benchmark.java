package utils;

import java.time.Duration;
import java.time.Instant;

public class Benchmark {

  private static final long MEGABYTE = 1024L * 1024L;

  public static Result run(Runnable solve) {
    // Get the Java runtime
    Runtime runtime = Runtime.getRuntime();
    // run garbage collector
    runtime.gc();

    // Calculate the used memory before execution
    long startMemory = runtime.totalMemory() - runtime.freeMemory();
    // Calculate the timestamp  before execution
    Instant startTime = Instant.now();
    // run the solution
    solve.run();
    // Calculate the timestamp  after execution
    Instant endTime = Instant.now();
    // Calculate the used memory before execution
    long endMemory = runtime.totalMemory() - runtime.freeMemory();

    long timeElapsed = Duration.between(startTime, endTime).toMillis();
    long memoryUsed = endMemory - startMemory;
    return new Result(timeElapsed, memoryUsed);
  }

  public static class Result {

    private final long timeElapsed;
    private final long memoryUsed;

    Result(long timeElapsed, long memoryUsed) {
      this.timeElapsed = timeElapsed;
      this.memoryUsed = memoryUsed;
    }

    long getTimeElapsed() {
      return this.timeElapsed;
    }

    long getMemoryUsed() {
      return this.memoryUsed;
    }

    private double byteToMB(double bytes) {
      return bytes / MEGABYTE;
    }

    @Override
    public String toString() {
      return "Time elapsed: " + timeElapsed + " ms\n"
          + "Memory used: " + byteToMB(memoryUsed) + " MB";
    }
  }

}

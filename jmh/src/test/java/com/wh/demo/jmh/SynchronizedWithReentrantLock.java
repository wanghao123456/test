package com.wh.demo.jmh;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SynchronizedWithReentrantLock {

    private int i = 0;

    private ReentrantLock reentrantLock = new ReentrantLock();

    @Benchmark
    public int synchronizedBenchmark() {
        synchronized (this) {
            i++;
        }
        return i;
    }

    @Benchmark
    public int reentrantLockBenchmark() {
        reentrantLock.lock();
        i++;
        reentrantLock.unlock();
        return i;
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(SynchronizedWithReentrantLock.class.getSimpleName())
                .forks(1)
                .threads(100)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();
        new Runner(options).run();
    }

}

package com.wh.demo.jmh;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class Test {

    @Param({"1000", "100000", "10000000"})
    private int length;

    private List<Integer> range;

    @Setup
    public void before() {
        List<Integer> list = new ArrayList<>(length);
        for (int i = 1; i <= length; i++) {
            list.add(i);
        }
        range = list;
    }


    @Benchmark
    public int stream() {
        return range.parallelStream().mapToInt(number -> number).sum();
    }

    @Benchmark
    public int foreach() {
        int result = 0;
        for (int number : range) {
            result += number;
        }
        return result;
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Test.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();
        new Runner(options).run();
    }
}

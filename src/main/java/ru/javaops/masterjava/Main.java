package ru.javaops.masterjava;

import ru.javaops.masterjava.matrix.MatrixUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] matrixA = MatrixUtil.create(1000);
        int[][] matrixB = MatrixUtil.create(1000);
        long startTime = System.currentTimeMillis();
        int[][] resultMatrix = MatrixUtil.singleThreadMultiply(matrixA, matrixB);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime = " + ((endTime - startTime) / 1000d) + " sec");

        ExecutorService executors = Executors.newFixedThreadPool(4);
        long startTime1 = System.currentTimeMillis();
        int[][] resultMatrix2 = MatrixUtil.concurrentMultiply(matrixA, matrixB, executors);
        long endTime1 = System.currentTimeMillis();
        System.out.println("endTime-startTime = " + ((endTime1 - startTime1) / 1000d) + " sec");

    }
}
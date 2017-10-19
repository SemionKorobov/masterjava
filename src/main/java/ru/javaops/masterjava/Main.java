package ru.javaops.masterjava;

import ru.javaops.masterjava.matrix.MatrixUtil;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrixA = MatrixUtil.create(1000);
        int[][] matrixB = MatrixUtil.create(1000);
        long startTime = System.currentTimeMillis();
        int[][] resultMatrix = MatrixUtil.singleThreadMultiply(matrixA, matrixB);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime = " + ((endTime - startTime) / 1000d) + " sec");
    }
}
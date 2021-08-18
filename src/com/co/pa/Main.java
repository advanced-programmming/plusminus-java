package com.co.pa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Main.plusMinus(arr);

        bufferedReader.close();
    }

    private static void plusMinus(List<Integer> arr) {
        BigDecimal pos = new BigDecimal(0).setScale(5, RoundingMode.HALF_UP);
        BigDecimal neg = new BigDecimal(0).setScale(5, RoundingMode.HALF_UP);
        BigDecimal zer = new BigDecimal(0).setScale(5, RoundingMode.HALF_UP);
        BigDecimal size = new BigDecimal(arr.size());

        for(Integer i : arr){
            if(i > 0) {
                pos = pos.add(BigDecimal.ONE);
            } else if (i == 0) {
                zer = zer.add(BigDecimal.ONE);
            } else {
                neg = neg.add(BigDecimal.ONE);
            }
        }

        pos = pos.divide(size, 5,  RoundingMode.HALF_UP);
        neg = neg.divide(size, 5,  RoundingMode.HALF_UP);
        zer = zer.divide(size, 5,  RoundingMode.HALF_UP);

        System.out.println(pos);
        System.out.println(neg);
        System.out.println(zer);
    }
}

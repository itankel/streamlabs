package com.ifat.bdd.utils;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FilesUtils {

    //LAB3_a
    @SneakyThrows
    public static int countNumOfWords(File file) {
        return new BufferedReader(new FileReader(file))
                .lines()
                .map(l -> l.split(" ").length)
                .mapToInt(i -> i)
                .sum();

    }

    //LAB3_b
    @SneakyThrows
    public static double avgLengthOfFilesWords(File file) {
        return new BufferedReader(new FileReader(file)).lines()
                .flatMap(l -> Arrays.stream(l.split(" ")))
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }
}

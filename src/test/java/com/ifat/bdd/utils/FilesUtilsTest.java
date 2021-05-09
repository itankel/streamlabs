package com.ifat.bdd.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FilesUtilsTest {

    @Test
    public void countNumOfWords() {
        int totalCount = FilesUtils
                .countNumOfWords(new File("C:\\Users\\User\\course\\BigDataDeveloper\\practice\\BDDStreamsLabs\\data\\file_for_word_count.txt"));
        System.out.println("totalCount = " + totalCount);
        Assert.assertEquals(18, totalCount);
    }

    @Test
    public void avgLengthOfFilesWords() {
        double avg = FilesUtils.avgLengthOfFilesWords(new File("C:\\Users\\User\\course\\BigDataDeveloper\\practice\\BDDStreamsLabs\\data\\file_for_word_count.txt"));
        System.out.println("avg = " + avg);
        Assert.assertEquals(3.94, avg, 0.01);
    }
}
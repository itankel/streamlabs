package com.ifat.bdd.advanced_hw;

import javax.lang.model.SourceVersion;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class DateUtil {

    public static void printBlackFridaySorted(int startYear, int endYear) {
        Map<Integer, Long> generatedBlackFridaysCounts = generateBlackFridaySorted(startYear, endYear);
        for (Map.Entry<Integer, Long> entry : generatedBlackFridaysCounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static  Map<Integer, Long> generateBlackFridaySorted(int startYear, int endYear){
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        return Stream.iterate(startDate, localDate -> localDate.plusDays(1))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(d -> d.getDayOfMonth() == 13)
                .takeWhile(d -> d.getYear() <= endYear)
                .collect(Collectors.groupingBy(LocalDate::getYear, TreeMap::new ,Collectors.counting()));
    }
}

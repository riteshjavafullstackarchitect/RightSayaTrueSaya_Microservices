package com.rightsaya.microservices.platform.testing.application.streams;

import com.rightsaya.functional.programs.RunExecuteJavaCodes;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class RightSayaStreams implements RunExecuteJavaCodes {

    public void runExecuteJavaCodes() {

        /*Given a list of integers,
        find out all the even numbers that exist in the list using Stream functions?
        */
        long[] longArray = new long[]{21,22,44,77,5234,973,99};
        LongStream longStream = (LongStream) Arrays.stream(longArray);

        longStream.filter((num) -> num%2 == 0).forEach(System.out::println);
        Arrays.stream(new int[]{21,22,44,77,5234,973,99}).
                asLongStream().filter((num) -> num%2 == 0).toArray();
        LongStream longStreamA = (LongStream) Arrays.stream(longArray);
        Supplier<StringBuilder> sb = () -> new StringBuilder();
        Predicate<Long> evenPredicate = (num) -> num % 2 == 0;
        Map<Boolean, List<Long>> result = longStreamA.boxed().collect(
                Collectors.partitioningBy(evenPredicate));

        result.entrySet().forEach((entry) ->
                        System.out.println(sb.get().append(" Key ").
                                append(entry.getKey()).append(" : Value ").
                                append(entry.getValue()).toString()));

        // Done

        /*
        *  Given a list of integers,
        * find out all the numbers starting with 1 using Stream functions?
        * */

        long[] longArrayNext = new long[]{12,222,1133,13,14,14,21,22,44,77,5234,973,99};
        LongStream longStreamNext = (LongStream) Arrays.stream(longArrayNext);
        Predicate<Long> numPred = (num) -> String.valueOf(num).startsWith("1");
        long[] furtherLongArr = longStreamNext.filter((num) -> numPred.test(num))
                .toArray();
        LongStream.of(furtherLongArr).forEach(System.out::println);

        List<Long> longList = Arrays.stream(furtherLongArr).boxed().toList();
        longList.stream().distinct().toList();
        Set<Long> longSet = new HashSet<>();
        Predicate<Long> numDuplicate = (num) -> !longSet.add(num);
        longList.stream().filter((num) -> numDuplicate.test(num))
                .forEach(System.out::println);

/*        Given the list of integers,
                find the first element of the list using Stream functions?*/
        Supplier<Long> longSupplier = () -> 100000L;
        System.out.println(Arrays.stream(longArrayNext).
                boxed().toList().stream()
                .sorted().findFirst().orElseGet(longSupplier));

        System.out.println(Arrays.stream(longArrayNext).spliterator().getExactSizeIfKnown());

    }
}
package com.rightsaya.microservices.platform.testing.application.collections;

import com.rightsaya.functional.programs.RunExecuteJavaCodes;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class RightSayaCollections implements RunExecuteJavaCodes {

    public void runExecuteJavaCodes() {

        Predicate<Integer> posNum = (num) -> num >= 0;

        System.out.println(posNum.test(2));

        Function<Integer, String> intStrFucntion = (num) -> String.valueOf(num);

        System.out.println(intStrFucntion.apply(2300));


    }
}

package com.rightsaya.functional.programs.function.interfaces;

import org.springframework.util.StringUtils;

import java.util.function.Predicate;

@FunctionalInterface
public interface HappyLearning extends Predicate<String> {

    default String getStringConcatenated(String[] params) {
        return StringUtils.concatenateStringArrays(new String[]{""}, params).toString();
    }

    static String[] getStringArrayConcatenated(String[] params) {
        return StringUtils.concatenateStringArrays(new String[]{""}, params);
    }

    private String getStringFromStringArray(String[] arr) {
        return arr.toString();
    }
}

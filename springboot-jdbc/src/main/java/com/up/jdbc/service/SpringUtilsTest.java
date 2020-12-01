package com.up.jdbc.service;

import org.springframework.util.StringUtils;

public class SpringUtilsTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.hasText(""));
        System.out.println(StringUtils.hasText(" "));
        System.out.println(StringUtils.hasText(null));
        System.out.println(StringUtils.hasText("test"));
        System.out.println("=============");

        System.out.println(StringUtils.hasLength(""));
        System.out.println(StringUtils.hasLength(" "));
        System.out.println(StringUtils.hasLength("test"));
        System.out.println(StringUtils.hasLength(null));
        System.out.println("===============");
        System.out.println(StringUtils.containsWhitespace(""));
        System.out.println(StringUtils.containsWhitespace(" "));
        System.out.println(StringUtils.containsWhitespace("test "));
        System.out.println(StringUtils.containsWhitespace(" test "));
        System.out.println(StringUtils.containsWhitespace(null));

    }
}

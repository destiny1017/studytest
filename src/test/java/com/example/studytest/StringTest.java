package com.example.studytest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class StringTest {

    @Test
    void reverseString() {
        StringBuilder str = new StringBuilder("hello world");
        str.reverse();
        System.out.println("str = " + str);
    }

    @Test
    void hashTest() {
        String data1 = "Hello World!"; // -969099747
        String data2 = // -2032006664
                "The class String includes methods for examining individual characters of the sequence," +
                " for comparing strings, for searching strings, for extracting substrings, " +
                "and for creating a copy of a string with all characters translated to uppercase or to lowercase. " +
                "Case mapping is based on the Unicode Standard version specified by the Character class.";
        ArrayList<Integer> data3 = new ArrayList<>(); // 1
        ArrayList<Integer> data4 = new ArrayList<>(); // 1
        ArrayList<Integer> data5 = new ArrayList<>(); // 12376
        data5.add(12345);

        System.out.println("data1.hashCode() = " + data1.hashCode());
        System.out.println("data2.hashCode() = " + data2.hashCode());
        System.out.println("data3.hashCode() = " + data3.hashCode());
        System.out.println("data4.hashCode() = " + data4.hashCode());
        System.out.println("data5.hashCode() = " + data5.hashCode());
        System.out.println("data3.equals(data4) = " + data3.equals(data4));

        HashMap<Integer, String> map = new HashMap<Integer, String>(16, 0.8f);
    }
    
}

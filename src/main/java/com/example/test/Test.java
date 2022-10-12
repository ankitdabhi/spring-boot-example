package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



interface Drwable{
    void paint();

    default int msg(int x) {
        return x;
    }
}

public class Test implements Drwable{
    public static void main(String[] args) {
        List<String> data=new ArrayList<>();
        data.add("test0");
        data.add("test1");
        data.add("test2");
        data.add("test3");
        data.add("test4");
        data.add("test5");
        data.subList(2,5).clear();
        System.out.println(data);
        Drwable d= () -> {
        };
        d.msg(10);
        String s="hello my name";
        String[] split = s.split("\\.");
        List<String> strings = Arrays.asList(split);
        strings.forEach(System.out::println);
        String ankit = revString("Ankit");
        System.out.println(ankit);
        System.out.println(revStringUsingStringBuilder("Ankit"));
        System.out.println(wordCapital("ankit dabhi"));
    }

    @Override
    public void paint() {

    }

    public static String revString(String sample){
        char[] chars = sample.toCharArray();
        String rev="";
        for (int i = chars.length-1; i >= 0; i--) {
            rev+=chars[i];
        }
        return rev;
    }

    public static String revStringUsingStringBuilder(String sample){
        StringBuilder stringBuilder=new StringBuilder(sample);
        return stringBuilder.reverse().toString();
    }

    public static String wordCapital(String word){
        String[] split = word.split("\\s");
        String capitalWords="";
        for (String s : split) {
            String first = s.substring(0, 1);
            String afterFirst = s.substring(1);
            capitalWords+=first.toUpperCase()+afterFirst+" ";
        }
        return capitalWords.trim();
    }
}

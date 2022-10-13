package com.example.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


interface Drwable {
    void paint();

    default int msg(int x) {
        return x;
    }
}

public class Test implements Drwable {
    public static void main(String[] args) {
        int[] sum={1,2,3};
        int[] ints = twoSum(sum, 3);
        Arrays.stream(ints).forEach(System.out::println);
        byte b1 = 101;    // Using b0, The b can be lower or upper case
        byte b2 = 0B101;    // Using B0
        System.out.println("----------Binary Literal in Byte----------------");
        System.out.println("b1 = "+b1);
        System.out.println("b2 = "+b2);

        List<String> data = new ArrayList<>();
        data.add("test0");
        data.add("test1");
        data.add("test2");
        data.add("test3");
        data.add("test4");
        data.add("test5");
        System.out.println("Remove value from string");
        data.subList(2, 5).clear();
        System.out.println(data);
        String s = "hello my name";
        String[] split = s.split("\\.");
        List<String> strings = Arrays.asList(split);
        System.out.println("Split string by space");
        System.out.println(strings);
        String ankit = revString("Ankit");
        System.out.println(ankit);
        System.out.println(revStringUsingStringBuilder("Ankit"));
        System.out.println(wordCapital("ankit dabhi"));

        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        double maxPrice = findMaxPrice(productsList);
        System.out.println(maxPrice);
        double minPrice = findMinPrice(productsList);
        System.out.println(minPrice);
        Set<Double> setData = convertListToSet(productsList);
        setData.forEach(System.out::println);
        Map<String, Double> listToMap = convertListToMap(productsList);
        System.out.println(listToMap);

    }

    private static Map<String, Double> convertListToMap(List<Product> productsList) {
        System.out.println("Convert list to map");
        return productsList.stream().collect(Collectors.toMap(product -> product.b, product -> product.c));
    }

    private static Set<Double> convertListToSet(List<Product> productsList) {
        System.out.println("Convert list to set");
        return productsList.stream().map(product -> product.c).collect(Collectors.toSet());
    }

    private static double findMinPrice(List<Product> productsList) {
        System.out.println("Find min from list");
        Product product = productsList.stream().min((pro1, pro2) -> pro1.c > pro2.c ? 1 : -1).get();
        return product.c;

    }

    private static double findMaxPrice(List<Product> productsList) {
        System.out.println("Find max from list");
        Product product = productsList.stream().max((pro1, pro2) -> pro1.c > pro2.c ? 1 : -1).get();
        return product.c;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + nums[i + 1];
            if (sum == target) {
                ans[0] = nums[i];
                ans[1] = nums[i + 1];
                return ans;
            }
        }
        return null;
    }
    static class Product {
        int a;
        String b;
        double c;

        public Product() {
        }

        public Product(int a, String b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public void paint() {

    }

    public static String revString(String sample) {
        char[] chars = sample.toCharArray();
        String rev = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            rev += chars[i];
        }
        System.out.println("Reverse String");
        return rev;
    }

    public static String revStringUsingStringBuilder(String sample) {
        System.out.println("Reverse String using StringBuilder");
        StringBuilder stringBuilder = new StringBuilder(sample);
        return stringBuilder.reverse().toString();
    }

    public static String wordCapital(String word) {
        String[] split = word.split("\\s");
        String capitalWords = "";
        for (String s : split) {
            String first = s.substring(0, 1);
            String afterFirst = s.substring(1);
            capitalWords += first.toUpperCase() + afterFirst + " ";
        }
        System.out.println("Word Capitalization");
        return capitalWords.trim();
    }
}

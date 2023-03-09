package com.qiusuo.memory.layout;

public class MeaureMemoryLayout {
    public static void main(String[] args) {
        String test = "xxxaabbccrry";

        isValid(test);
    }

    public static String isValid(String s) {
        // Write your code here
        int[] frequencies = new int[26];
        int min = 0;
        int minOccurances = 0;
        int max = 0;
        int maxOccurances = 0;
        for (int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (min == 0 && max == 0) {
                min = frequencies[i];
                max = frequencies[i];
                maxOccurances = 1;
                minOccurances = 1;
            }
            if (frequencies[i] != 0) {
                if (frequencies[i] == min) {
                    minOccurances++;
                }
                if (frequencies[i] < min) {
                    min = frequencies[i];
                    minOccurances = 1;
                }
                if (frequencies[i] == max) {
                    maxOccurances++;
                }
                if (frequencies[i] > max) {
                    max = frequencies[i];
                    maxOccurances = 1;
                }
            }
        }


        if (max != min) {
            if ((max - min) != 1) {
                if (max == 1 || min == 1 &&) {//how to verify when max-min!=1. But there are no numbers in between
                    return "YES";
                }
                return "NO";
            }
            if (maxOccurances != 1 && minOccurances != 1) {
                return "NO";
            }
        }
        System.out.println(frequencies);
        return "YES";
    }
    

}

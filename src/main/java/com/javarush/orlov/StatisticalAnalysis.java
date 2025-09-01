package com.javarush.orlov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalysis {

    public ArrayList<String> statisticalAnalysis(ArrayList<String> text){
        ArrayList<String> result = new ArrayList<>();
        char top = ' ';

        for (int i = 0; i < text.size(); i++) {
           top =  word(text.get(i));
        }

        int key = differenceWithSpace(top);
        Decrypt decrypt = new Decrypt();
        result=  decrypt.decrypt(text, key);


        return result;
    }

    private char word (String line){
        HashMap<Character, Integer> count = new HashMap<>();

        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        char mostFrequent = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }

    public static int differenceWithSpace(char mostFrequent) {
        int indexMostFrequent = -1;
        int indexSpace = -1;

        for (int i = 0; i < Encrypt.ALPHABET.length; i++) {
            if (Encrypt.ALPHABET[i] == mostFrequent) {
                indexMostFrequent = i;
            }
            if (Encrypt.ALPHABET[i] == ' ') {
                indexSpace = i;
            }
        }

        if (indexMostFrequent == -1 || indexSpace == -1) {
            throw new IllegalArgumentException("Символ не найден в алфавите");
        }

        return indexMostFrequent - indexSpace; // разница позиций
    }

}
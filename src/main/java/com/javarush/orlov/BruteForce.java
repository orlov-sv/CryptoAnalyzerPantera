package com.javarush.orlov;

import java.util.ArrayList;

public class BruteForce extends Encrypt{
    private static final String[] DICTIONARY= {"и", "в", "на", "что", "как", "это", "он", "она", "они"};

    public ArrayList<String> bruteForce (ArrayList<String> text){
        ArrayList<String> result;
        int key = 0;
        int count = 0;

        for (int i = 0; i < ALPHABET.length; i++) {
            result = super.encrypt(text, i);
            int temp = extracted(result);
            if (temp > count){
                key = i;
                count = temp;
            }
        }
        return super.encrypt(text, key);
    }

    private static int extracted(ArrayList<String> result) {
        int count = 0;
        for (int j = 0; j < result.size(); j++) {
            count += checkWord(result.get(j));
        }
        return count;
    }


    private static int checkWord(String str){
        int count = 0;
        String[] word = str.split(" ");

        for (int i = 0; i < word.length; i++) {
            word[i] = word[i].replaceAll("[^а-яА-Я]","");
            for (int j = 0; j < DICTIONARY.length; j++) {
                if (word[i].equalsIgnoreCase(DICTIONARY[j])){
                    count++;
                }
            }

        }

        return count;
    }
}

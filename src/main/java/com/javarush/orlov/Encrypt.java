package com.javarush.orlov;

public class Encrypt {
    // шифрование и дешифрование с помощью ключа
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', 'А', 'Б', 'В', 'Г', 'Д',
            'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н' , 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш',
            'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};


    public String encrypt(String text, int key){

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            boolean found = false;
            for (int j = 0; j < ALPHABET.length; j++) {
                if (text.charAt(i) == ALPHABET[j]){
                    builder.append(ALPHABET[(j + key) % ALPHABET.length]);
                    found = true;
                    break;
                }

            }
            if (!found) builder.append(text.charAt(i));
        }
        String result = builder.toString();
        return result;
    }



}

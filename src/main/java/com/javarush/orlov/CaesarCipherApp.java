package com.javarush.orlov;

import java.io.IOException;

public class CaesarCipherApp {


    public static void main(String[] args) throws IOException {

        String text = new String(FileService.readFile("text\\text.txt"));
        FileService.createNewFile("text\\");
        Encrypt cipher = new Encrypt();
        //;
        FileService.writeFile("text\\encrypted.txt",cipher.encrypt(text, 3));
    }
}

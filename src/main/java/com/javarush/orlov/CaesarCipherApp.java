package com.javarush.orlov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class CaesarCipherApp {


    public static void main(String[] args) throws IOException {

        ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\text.txt")));


        FileService.createNewFile("text\\");
        Encrypt encrypt = new Encrypt();

        FileService.writeFile("text\\encrypted.txt",encrypt.encrypt(text, 3));
    }
}

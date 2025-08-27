package com.javarush.orlov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class CaesarCipherApp {

    public static void main(String[] args) throws IOException {

        while (true) {
            int num = Validator.begin();

            switch (num){
                case  0:
                    System.out.println("Выход из программы. Пока!");
                    return;

                case  1:
                    encryptFile();
                    System.out.println("Готово!");
                    break;

                case  2:
                decryptFile();
                System.out.println("Готово! ");
                break;

                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
            }
            }
        }

        private static void encryptFile () throws IOException {
            int key = Validator.scanKey();

            ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\text.txt")));

            FileService.createNewFile("text\\encrypted.txt");
            Encrypt encrypt = new Encrypt();
            ArrayList<String> result = new ArrayList<>(encrypt.encrypt(text, key));
            FileService.writeFile("text\\encrypted.txt", result);
        }

        private static void decryptFile () throws IOException {
            int key = Validator.scanKey();

            ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\encrypted.txt")));
            FileService.createNewFile("text\\decrypt.txt");

            Decrypt decrypt = new Decrypt();

            FileService.writeFile("text\\decrypt.txt", decrypt.decrypt(text, key));
        }
    }


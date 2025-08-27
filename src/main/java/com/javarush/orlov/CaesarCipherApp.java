package com.javarush.orlov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CaesarCipherApp {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Это программа для работы с шифром Цезаря \n");
        while (true) {
            System.out.println("********************************************************** \n " +
                    " Выберите: \n " +
                    "1. Зашифровать файл \n " +
                    "2. Расшифровать файл \n " +
                    "3. Взлом (Brute Force) \n " +
                    "4. Взлом (Статистический анализ) \n " +
                    "0. Выход ");

            short num;
            int key;

            while (true) {
                try {

                    num = scanner.nextShort();
                    if (num >= 0 && num <= 4) break;
                    else {
                        System.out.println("Некорректный ввод");

                        System.out.println(" Выберите: \n " +
                                "1. Зашифровать файл \n " +
                                "2. Расшифровать файл \n " +
                                "3. Взлом (Brute Force) \n " +
                                "4. Взлом (Статистический анализ) \n " +
                                "0. Выход ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Нужно ввести цифру от 1 до 4!!");
                    scanner.next();
                    System.out.println(" Выберите: \n " +
                            "1. Зашифровать файл \n " +
                            "2. Расшифровать файл \n " +
                            "3. Взлом (Brute Force) \n " +
                            "4. Взлом (Статистический анализ) \n " +
                            "0. Выход");

                }
            }

            if (num == 0){
                System.out.println("Выход из программы. Пока!");
                break;
            }
            else if (num == 1) {
                System.out.println("Введите ключ");
                key = scanner.nextInt();

                ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\text.txt")));


                FileService.createNewFile("text\\encrypted.txt");
                Encrypt encrypt = new Encrypt();
                ArrayList<String> result = new ArrayList<>(encrypt.encrypt(text, key));
                FileService.writeFile("text\\encrypted.txt", result);
                System.out.println("Готово!");

            } else if (num == 2) {
                System.out.println("Введите ключ");
                key = scanner.nextInt();

                ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\encrypted.txt")));
                FileService.createNewFile("text\\decrypt.txt");

                Decrypt decrypt = new Decrypt();

                FileService.writeFile("text\\decrypt.txt", decrypt.decrypt(text, key));
                System.out.println("Готово! ");

            }


        }
    }
}

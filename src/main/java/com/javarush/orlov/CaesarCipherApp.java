package com.javarush.orlov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CaesarCipherApp {

    public static void main(String[] args) throws IOException {

        // Главный цикл программы, пока пользователь не выберет выход
        while (true) {
            int num = Validator.begin(); // Получаем выбор пользователя

            switch (num) {
                case 0:
                    System.out.println("Выход из программы. Пока!");
                    return;

                case 1:
                    encryptFile(); // Шифруем файл
                    System.out.println("Готово!");
                    break;

                case 2:
                    decryptFile(); // Расшифровываем файл по ключу
                    System.out.println("Готово!");
                    break;

                case 3:
                    bruteForceFile(); // Расшифровка методом полного перебора
                    System.out.println("Готово!");
                    break;

                case 4:
                    statisticalFile(); // Расшифровка статистическим анализом
                    System.out.println("Готово!");
                    break;

                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
            }
        }
    }

    // Метод для шифрования текста из файла
    private static void encryptFile() throws IOException {
        int key = Validator.scanKey(); // Считываем ключ от пользователя

        // Читаем текст из файла
        ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\text.txt")));

        // Создаём новый файл для зашифрованного текста
        FileService.createNewFile("text\\encrypted.txt");

        // Шифруем текст с указанным ключом
        Encrypt encrypt = new Encrypt();
        ArrayList<String> result = new ArrayList<>(encrypt.encrypt(text, key));

        // Записываем результат в файл
        FileService.writeFile("text\\encrypted.txt", result);
    }

    // Метод для расшифровки текста по ключу
    private static void decryptFile() throws IOException {
        int key = Validator.scanKey(); // Считываем ключ от пользователя

        // Читаем зашифрованный текст
        ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\encrypted.txt")));

        // Создаём файл для расшифрованного текста
        FileService.createNewFile("text\\decrypt.txt");

        // Расшифровываем текст
        Decrypt decrypt = new Decrypt();
        FileService.writeFile("text\\decrypt.txt", decrypt.decrypt(text, key));
    }

    // Метод для расшифровки текста методом полного перебора (Brute Force)
    private static void bruteForceFile() throws IOException {
        ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\encrypted.txt")));

        // Создаём файл для результата
        FileService.createNewFile("text\\bruteForce.txt");

        BruteForce bruteForce = new BruteForce();

        // Записываем расшифрованный текст с найденным ключом
        FileService.writeFile("text\\bruteForce.txt", bruteForce.bruteForce(text));
    }

    // Метод для расшифровки текста статистическим анализом
    private static void statisticalFile() throws IOException {
        ArrayList<String> text = new ArrayList<>(Files.readAllLines(Path.of("text\\encrypted.txt")));

        // Создаём файл для результата
        FileService.createNewFile("text\\statisticalAnalysis.txt");

        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();

        // Записываем расшифрованный текст
        FileService.writeFile("text\\statisticalAnalysis.txt", statisticalAnalysis.statisticalAnalysis(text));
    }
}

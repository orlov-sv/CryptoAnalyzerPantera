package com.javarush.orlov;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    // Разделитель для визуального оформления меню
    private static final String asterisk = "*".repeat(60);

    // Метод отображает главное меню программы и возвращает выбор пользователя
    public static int begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Это программа для работы с шифром Цезаря \n");

        while (true) {
            // Вывод меню
            System.out.println(asterisk +
                    " Выберите: \n" +
                    "1. Зашифровать файл \n" +
                    "2. Расшифровать файл \n" +
                    "3. Взлом (Brute Force) \n" +
                    "4. Взлом (Статистический анализ) \n" +
                    "0. Выход ");

            short num;

            while (true) {
                try {
                    num = scanner.nextShort(); // считываем выбор пользователя

                    // Проверяем корректность ввода
                    if (num >= 0 && num <= 4) return num;
                    else {
                        System.out.println("Некорректный ввод. Нужно выбрать число от 0 до 4.");
                    }

                } catch (InputMismatchException e) {
                    // Если введено не число, выводим сообщение и очищаем ввод
                    System.out.println("Нужно ввести цифру от 0 до 4!");
                    scanner.next(); // очищаем некорректный ввод
                }

                // Повторный вывод меню
                System.out.println("Выберите: \n" +
                        "1. Зашифровать файл \n" +
                        "2. Расшифровать файл \n" +
                        "3. Взлом (Brute Force) \n" +
                        "4. Взлом (Статистический анализ) \n" +
                        "0. Выход");
            }
        }
    }

    // Метод запрашивает у пользователя ключ для шифра Цезаря
    public static int scanKey() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Введите ключ:");
                return scanner.nextInt(); // возвращаем введённый ключ
            } catch (InputMismatchException e) {
                // Если введено не число, выводим сообщение и очищаем ввод
                System.out.println("Нужно ввести цифру!!");
                scanner.next(); // очищаем некорректный ввод
            }
        }
    }
}

package com.javarush.orlov;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    //проверка входных данных
    private static final String asterisk = "*".repeat(60);

    public static int begin (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Это программа для работы с шифром Цезаря \n");
        while (true) {
            System.out.println( asterisk +
                    " Выберите: \n" +
                    "1. Зашифровать файл \n" +
                    "2. Расшифровать файл \n" +
                    "3. Взлом (Brute Force) \n" +
                    "4. Взлом (Статистический анализ) \n" +
                    "0. Выход ");

            short num;


            while (true) {
                try {

                    num = scanner.nextShort();
                    if (num >= 0 && num <= 4) return num;
                    else {
                        System.out.println("Некорректный ввод");

                        System.out.println(" Выберите:\n" +
                                "1. Зашифровать файл \n" +
                                "2. Расшифровать файл \n" +
                                "3. Взлом (Brute Force) \n" +
                                "4. Взлом (Статистический анализ) \n" +
                                "0. Выход ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Нужно ввести цифру от 1 до 4!!");
                    scanner.next();
                    System.out.println(" Выберите: \n" +
                            "1. Зашифровать файл \n" +
                            "2. Расшифровать файл \n" +
                            "3. Взлом (Brute Force) \n" +
                            "4. Взлом (Статистический анализ) \n" +
                            "0. Выход");

                }
            }
    }

}

    public static int scanKey (){
        Scanner scanner = new Scanner(System.in);
       while (true) {
           try {
               System.out.println("Введите ключ");
               return scanner.nextInt();
           } catch (InputMismatchException e) {
               System.out.println("Нужно ввести цифру!!");
               scanner.next();
           }
       }
    }
}

package com.javarush.orlov;

import java.util.ArrayList;

public class Decrypt {

    // Метод расшифровывает текст, используя ключ шифра Цезаря
    // Для расшифровки используется метод шифрования с отрицательным ключом
    public ArrayList<String> decrypt(ArrayList<String> text, int key){

        // Создаём объект класса Encrypt для работы с шифром Цезаря
        Encrypt encrypt = new Encrypt();

        // Возвращаем результат шифрования с отрицательным ключом,
        // что фактически выполняет расшифровку
        return encrypt.encrypt(text, -key);
    }
}

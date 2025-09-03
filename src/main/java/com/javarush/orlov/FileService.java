package com.javarush.orlov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileService {

    // Метод для чтения содержимого файла в виде строки
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);                 // получаем путь к файлу
        byte[] bytes = Files.readAllBytes(path);         // читаем все байты из файла
        return new String(bytes, StandardCharsets.UTF_8); // преобразуем байты в строку с кодировкой UTF-8
    }

    // Метод для создания нового файла
    // Если файл уже существует — удаляет его и создаёт новый
    public static void createNewFile(String filePath) throws IOException {
        Path path = Path.of(filePath);   // путь к файлу

        if (Files.exists(path)) {        // проверяем, существует ли файл
            Files.delete(path);          // если да — удаляем
        }
        Files.createFile(path);          // создаём новый файл
    }

    // Метод для записи текста в файл
    public static void writeFile(String filePath, ArrayList<String> str) {
        Path path = Paths.get(filePath); // путь к файлу
        try {
            StringBuilder builder = new StringBuilder();

            // Объединяем все строки с переносами
            for (String line : str) {
                builder.append(line).append(System.lineSeparator());
            }

            // Запись в файл с явным указанием кодировки UTF-8
            Files.writeString(path, builder.toString(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            // Вывод ошибки, если запись не удалась
            System.out.println("Ошибка записи файла: " + e.getMessage());
        }
    }
}

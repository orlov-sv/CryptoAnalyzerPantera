package com.javarush.orlov;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileService {
    // работа с файлами
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);

    }
    public static void createNewFile(String filePath) throws IOException {

        Path path = Path.of(filePath + "encrypted.txt");    // путь к файлу, где будет храниться зашифрованный текст
        if (Files.exists(path)){                                // проверка на существование файла
            Files.delete(path);                                 //если существует, то удалаем и создаём новый
            Files.createFile(path);
        }
        else Files.createFile(path);

    }
}

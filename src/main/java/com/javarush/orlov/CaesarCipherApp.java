package com.javarush.orlov;

import java.io.IOException;

public class CaesarCipherApp {
    public static void main(String[] args) throws IOException {

        String text = new String(FileService.readFile("C:\\Users\\s_m_o\\IdeaProjects\\CryptoAnalyzerPantera\\text\\text.txt"));
        FileService.createNewFile("C:\\Users\\s_m_o\\IdeaProjects\\CryptoAnalyzerPantera\\text\\");
    }
}

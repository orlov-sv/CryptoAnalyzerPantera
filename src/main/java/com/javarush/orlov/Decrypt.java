package com.javarush.orlov;

import java.util.ArrayList;

public class Decrypt extends Encrypt{

    public ArrayList<String> decrypt(ArrayList<String> text, int key){

        return super.encrypt(text, -key);
    }
}

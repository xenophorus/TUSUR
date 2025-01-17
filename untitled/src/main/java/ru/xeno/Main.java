package ru.xeno;

import java.util.HashMap;
import java.util.Map;

class Catty {
    int x = 1;
    public void printX() {
        System.out.println(x);
    }
}

class Kitten extends Catty {
    int x = -1;
    public void printX() {
        System.out.println(x);
    }
}

public class Main {
    public static void main(String[] args) {
        int x = 18; int y = x++;
        if (y > 10) {
            System.out.println("asdasd");
        }
    }
}
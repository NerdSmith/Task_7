package ru.vsu.cs;

import ru.vsu.cs.view.View;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View();
            }
        });
    }
}

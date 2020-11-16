package ru.vsu.cs.GuiMain;

import ru.vsu.cs.GuiMain.view.View;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View();
            }
        });
    }
}

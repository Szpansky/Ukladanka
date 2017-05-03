package gra;

import javax.swing.JFrame;

public class Gra {

    public static void main(String[] args) {
        OknoMenu menu = new OknoMenu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

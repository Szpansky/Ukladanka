package gra;

import javax.swing.JFrame;

public class Gra {

    public static void main(String[] args) {
                                                    // TODO Okno z menu gl

        OknoMenu menu = new OknoMenu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
      //  menu.repaint();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //OknoGry gra = new OknoGry();
        //gra.setLocationRelativeTo(null);
        //gra.setVisible(true);

    }
}

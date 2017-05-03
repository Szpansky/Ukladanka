package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoMenu extends JFrame implements ActionListener {

    JButton nowa_gra = new JButton("Nowa Gra");
    JButton informacje = new JButton("Informacje");
    JButton wyjscie = new JButton("Wyjscie");
    OknoGry gra;

    public OknoMenu() throws HeadlessException {
        super("Menu");
        this.setSize(500, 300);

        nowa_gra.setSize(50, 150);
        informacje.setSize(50, 150);
        wyjscie.setSize(50, 150);

        setLayout(new GridLayout(3, 1));
        add(nowa_gra);
        add(informacje);
        add(wyjscie);

        nowa_gra.addActionListener(this);
        informacje.addActionListener(this);
        wyjscie.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            gra.dispose();              //usuwanie starych obiektów gry
        } catch (Exception e1) {
            System.out.println("Brak obiektu do usuniecia");
        }

        if (e.getSource() == nowa_gra) {
            gra = new OknoGry();
            gra.setLocationRelativeTo(null);
            gra.setVisible(true);
        } else if (e.getSource() == informacje)
            JOptionPane.showMessageDialog(null, "W grze mamy do dyspozycji jeden pusty element \n" +
                    "którym musimy w poprawny sposób ułożyć cały obrazek.\n" +
                    "By pomieszać klocki naciskamy F2,\n" +
                    "Sterowanie strzałkami ");
        else if (e.getSource() == wyjscie) {
            try {
                gra.dispose();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Szkoda że nie zagrałeś");
            }
            this.dispose();
            System.out.println("Zakonczono gre");
        } else
            System.out.println("Blad");
    }
}

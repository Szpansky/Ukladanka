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

    public OknoMenu() throws HeadlessException {
        super("Menu");
        this.setSize(500, 300);


        nowa_gra.setSize(50,150);
        informacje.setSize(50,150);
        wyjscie.setSize(50,150);


        setLayout(new GridLayout(3,1));
        add(nowa_gra);
        add(informacje);
        add(wyjscie);


        nowa_gra.addActionListener(this);
        informacje.addActionListener(this);
        wyjscie.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nowa_gra)
            System.out.println("Rozpoczecie nowej gry!");           // TODO fukcje obslugujace przyciski
        else if (e.getSource() == informacje)
            System.out.println("Info!");
        else if (e.getSource() == wyjscie) {
            System.out.println(" Wyjscie");
            dispose();
        }
        else
            System.out.println("Blad");
    }
}


package com.sliderimagine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SlideImagine extends JFrame{
    JLabel label;
    Timer timp;
    int x = 0;
    JButton masinaButton;


    //Images Path In Array
    String[] list = {
            "C:/Users/Razvan/Desktop/masina1.jpg",//0
            "C:/Users/Razvan/Desktop/masina2.jpg",//1
    };

    public SlideImagine(){
        label = new JLabel();
        label.setSize(900,500);
        this.setTitle("Slide Imagine");

        // Creaza buttonPanel care va contine butoanele
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        // Precizeaza layout pentru buttonPanel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));

        //Butonul masini
        masinaButton = new JButton("MASINI");
        masinaButton.setPreferredSize(new Dimension(150,40));
        masinaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        masinaButton.setBackground(Color.LIGHT_GRAY);

        //adaugare butonpanel
        buttonPanel.add(masinaButton);

        // Adauga buttonPanel la mainPanel
        label.add(buttonPanel, BorderLayout.SOUTH);

        //Chemare imagini
        SetImageSize(1);


        //set a timer
        timp = new Timer(2500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0;
            }
        });
        add(label);
        timp.start();
        setLayout(null);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //create a function to resize the image
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        label.setIcon(newImc);
    }
}
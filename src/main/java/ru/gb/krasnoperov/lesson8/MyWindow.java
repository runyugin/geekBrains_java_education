package ru.gb.krasnoperov.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        final JButton button1 = new JButton("Button #1");
        final JButton button2 = new JButton("Button #2");
        final JButton button3 = new JButton("Button #3");
        final JButton button4 = new JButton("Button #4");
        final JButton button5 = new JButton("Button #5");

        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.SOUTH);
        add(button3, BorderLayout.WEST);
        add(button4, BorderLayout.EAST);
        add(button5, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton button = (JButton) e.getSource();

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}

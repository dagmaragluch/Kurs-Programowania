/**
 * Paint
 *
 * @ author: Dagmara Gluch
 * @ version 1.2
 */

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    DrawArea drawArea = new DrawArea();

    private JButton bInfo, bProstokat, bKolo, bPrzesun, bNiebieski, bZielony,
            bWiekszy, bMniejszy, bWielokat, bSave, bLoad, bCzerwony;


    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bProstokat) {
                Toolbar.selectedTool = 1;
            } else if (e.getSource() == bKolo) {
                Toolbar.selectedTool = 2;
            } else if (e.getSource() == bPrzesun) {
                Toolbar.selectedTool = 3;
            } else if (e.getSource() == bZielony) {
                Toolbar.selectedTool = 4;
            } else if (e.getSource() == bNiebieski) {
                Toolbar.selectedTool = 5;
            } else if (e.getSource() == bWiekszy) {
                Toolbar.selectedTool = 6;
            } else if (e.getSource() == bMniejszy) {
                Toolbar.selectedTool = 7;
            } else if (e.getSource() == bInfo) {
                JOptionPane.showMessageDialog(null, "Prosty edytor graficzny\n autor: Dagmara Gluch");
            } else if (e.getSource() == bWielokat) {
                Toolbar.selectedTool = 8;
            } else if (e.getSource() == bSave) {
                Toolbar.selectedTool = 9;
            } else if (e.getSource() == bLoad) {
                Toolbar.selectedTool = 10;
            } else if (e.getSource() == bCzerwony) {
                Toolbar.selectedTool = 11;
            }
        }
    };


    public static void main(String[] args) {
        new Main().show();
    }

    public void show() {
        JFrame frame = new JFrame("Paint");
        frame.setResizable(false);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(drawArea, BorderLayout.CENTER);
        Container content2 = frame.getContentPane();
        content2.setLayout(new BorderLayout());
        content2.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JPanel controls2 = new JPanel();

        bProstokat = new JButton("Prostokat");
        bProstokat.addActionListener(actionListener);
        bKolo = new JButton("Kolo");
        bKolo.addActionListener(actionListener);
        bPrzesun = new JButton("Przesuń");
        bPrzesun.addActionListener(actionListener);
        bNiebieski = new JButton("Niebieski");
        bNiebieski.addActionListener(actionListener);
        bZielony = new JButton("Zielony");
        bZielony.addActionListener(actionListener);
        bCzerwony = new JButton("Czerwony");
        bCzerwony.addActionListener(actionListener);
        bWiekszy = new JButton("Większy");
        bWiekszy.addActionListener(actionListener);
        bMniejszy = new JButton("Mniejszy");
        bMniejszy.addActionListener(actionListener);
        bInfo = new JButton("Info");
        bInfo.addActionListener(actionListener);
        bWielokat = new JButton("Wielokąt");
        bWielokat.addActionListener(actionListener);
        bSave = new JButton("Save");
        bSave.addActionListener(actionListener);
        bLoad = new JButton("Load");
        bLoad.addActionListener(actionListener);

        controls.add(bKolo);
        controls.add(bProstokat);
        controls.add(bWielokat);
        controls.add(bPrzesun);
        controls.add(bWiekszy);
        controls.add(bMniejszy);

        controls2.add(bCzerwony);
        controls2.add(bNiebieski);
        controls2.add(bZielony);
        controls2.add(bInfo);
        controls2.add(bSave);
        controls2.add(bLoad);

        content.add(controls, BorderLayout.NORTH);
        content2.add(controls2, BorderLayout.SOUTH);


        frame.setSize(615, 635);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}

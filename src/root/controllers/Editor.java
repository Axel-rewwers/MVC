package root.controllers;

import root.model.Wall;
import root.utils.Keyboard;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Editor {



    public void editWall(Wall wall) {

        Keyboard.setKeys(KeyEvent.VK_E, false);


        //редактируем стену в отдельном окне

        JFrame editFrame = new JFrame("edit this wall");

        editFrame.setResizable(false);
        editFrame.setSize(300, 300);
        editFrame.setLayout(null);

        JLabel labelWidth = new JLabel("Width");
        labelWidth.setBounds(10, 20, 100, 50);
        editFrame.add(labelWidth);

        JLabel labelHeight = new JLabel("Height");
        labelHeight.setBounds(10, 90, 100, 50);
        editFrame.add(labelHeight);

        JTextField tfWidth = new JTextField(String.valueOf(wall.getWidth()));
        tfWidth.setBounds(10, 50, 100, 50);
        editFrame.add(tfWidth);

        JTextField tfHeight = new JTextField(String.valueOf(wall.getHeight()));
        tfHeight.setBounds(10, 120, 100, 50);
        editFrame.add(tfHeight);

        JCheckBox jCheckBox = new JCheckBox("is unbreakable");
        jCheckBox.setBounds(140, 10, 100, 20);
        jCheckBox.setSelected(wall.isUnbreakable());

        JTextField tfHealthPointCurrent = new JTextField(String.valueOf(wall.getHealthPointCurrent()));
        tfHealthPointCurrent.setBounds(140, 120, 100, 50);
        editFrame.add(tfHealthPointCurrent);
        tfHealthPointCurrent.setVisible(!jCheckBox.isSelected());


        JLabel healthPointCurrent = new JLabel("HPCurrent");
        healthPointCurrent.setBounds(140, 90, 100, 50);
        editFrame.add(healthPointCurrent);
        healthPointCurrent.setVisible(!jCheckBox.isSelected());


        JTextField tfHealthPoint = new JTextField(String.valueOf(wall.getHealthPoint()));
        tfHealthPoint.setBounds(140, 50, 100, 50);
        editFrame.add(tfHealthPoint);
        tfHealthPoint.setVisible(!jCheckBox.isSelected());

        JLabel labelHealthPoint = new JLabel("HealthPoint");
        labelHealthPoint.setBounds(140, 20, 100, 50);
        editFrame.add(labelHealthPoint);
        labelHealthPoint.setVisible(!jCheckBox.isSelected());


        JButton btnApply = new JButton("применить");
        btnApply.setBounds(10, 200, 100, 50);

        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double width;
                double height;
                double healthCurr;
                double health;
                try {
                    width = Double.parseDouble(tfWidth.getText());
                    height = Double.parseDouble(tfHeight.getText());


                    wall.setWidth(width);
                    wall.setHeight(height);
                    if (!jCheckBox.isSelected()) {
                        healthCurr = Double.parseDouble(tfHealthPointCurrent.getText());
                        health = Double.parseDouble(tfHealthPoint.getText());
                        wall.setHealthPointCurrent((int) healthCurr);
                        wall.setHealthPoint((int) health);
                    }

                    btnApply.setForeground(Color.green.darker());
                } catch (NumberFormatException ex) {
                    btnApply.setForeground(Color.red);

                }

            }
        });

        JButton btnOk = new JButton("ОК");
        btnOk.setBounds(140, 200, 100, 50);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFrame.dispose();
            }
        });


        tfHeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                labelHeight.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                labelHeight.setVisible(true);
            }
        });



        jCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double health1;
                if(jCheckBox.isSelected()) {
                    wall.setUnbreakable(true);
                    System.out.println("action listener" + jCheckBox.isSelected());
                    tfHealthPoint.setVisible(false);
                    labelHealthPoint.setVisible(false);
                    tfHealthPointCurrent.setVisible(false);
                    healthPointCurrent.setVisible(false);

                }else{
                    wall.setUnbreakable(false);
                    System.out.println("action listener" + jCheckBox.isSelected());
                    tfHealthPoint.setVisible(true);
                    labelHealthPoint.setVisible(true);
                    tfHealthPointCurrent.setVisible(true);
                    healthPointCurrent.setVisible(true);
                }
            }
        });

        editFrame.add(jCheckBox);
        editFrame.add(btnOk);
        editFrame.add(btnApply);


        editFrame.setVisible(true);

    }


}

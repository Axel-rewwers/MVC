package root.controllers;

import root.model.Wall.FactoryWall;
import root.model.Wall.TypeWall;
import root.model.Wall.Wall;
import root.utils.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editor {
    private FactoryWall factoryWall;
    private SwitchListener<Wall> switchListener;


    ////UI ELEMENTS///////////////
    private JFrame editFrame;
    private JTextField tfWidth;
    private JTextField tfHeight;
    private JTextField tfHealthPoint;
    private JTextField tfHealthPointCurrent;
    private JComboBox<TypeWall> jComboBox;
    private  JCheckBox jCheckBox;
    private JButton btnApply;
    ////END UI ELEMENTS///////////


    private Wall wall;



    public Editor(){
        factoryWall = new FactoryWall();
    }

    public void editWall(Wall wallEdit) {

        wall = wallEdit;
        Keyboard.setKeys(KeyEvent.VK_E, false);


        //редактируем стену в отдельном окне

        editFrame = new JFrame("edit this wall");

        editFrame.setResizable(false);
        editFrame.setSize(300, 300);
        editFrame.setLayout(null);


//Width
        JLabel labelWidth = new JLabel("Width");
        labelWidth.setBounds(10, 10, 100, 10);
        editFrame.add(labelWidth);

        tfWidth = new JTextField(String.valueOf(wall.getWidth()));
        tfWidth.setBounds(10, 20, 100, 30);
        editFrame.add(tfWidth);
//Heigth
        JLabel labelHeight = new JLabel("Height");
        labelHeight.setBounds(10, 55, 100, 10);
        editFrame.add(labelHeight);

        tfHeight = new JTextField(String.valueOf(wall.getHeight()));
        tfHeight.setBounds(10, 65, 100, 30);
        editFrame.add(tfHeight);
//is unbreakable
        jCheckBox = new JCheckBox("is unbreakable");
        jCheckBox.setBounds(140, 10, 100, 20);
        jCheckBox.setSelected(wall.isUnbreakable());
//HPCurrent
        JLabel healthPointCurrent = new JLabel("HPCurrent");
        healthPointCurrent.setBounds(140, 90, 100, 50);
        editFrame.add(healthPointCurrent);
        healthPointCurrent.setVisible(!jCheckBox.isSelected());

        tfHealthPointCurrent = new JTextField(String.valueOf(wall.getHealthPointCurrent()));
        tfHealthPointCurrent.setBounds(140, 120, 100, 50);
        editFrame.add(tfHealthPointCurrent);
        tfHealthPointCurrent.setVisible(!jCheckBox.isSelected());
//HealthPoint
        JLabel labelHealthPoint = new JLabel("HealthPoint");
        labelHealthPoint.setBounds(140, 20, 100, 50);
        editFrame.add(labelHealthPoint);
        labelHealthPoint.setVisible(!jCheckBox.isSelected());

        tfHealthPoint = new JTextField(String.valueOf(wall.getHealthPoint()));
        tfHealthPoint.setBounds(140, 50, 100, 50);
        editFrame.add(tfHealthPoint);
        tfHealthPoint.setVisible(!jCheckBox.isSelected());
//применить
        btnApply = new JButton("применить");
        btnApply.setBounds(10, 200, 100, 50);

        //тип стены
        //
        TypeWall[] items = TypeWall.values();
        jComboBox = new JComboBox(items);
        jComboBox.setBounds(10,100,100,30);
        jComboBox.setSelectedItem(wall.getType());
        jComboBox.addItemListener(new SelectItemComboBox());
        editFrame.add(jComboBox);

        btnApply.addActionListener(new ApplyListener());


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
        editFrame.add(btnApply);



        editFrame.setVisible(true);

    }

    public void setSwitchListener(SwitchListener<Wall> listener){
        switchListener = listener;
    }


    class SelectItemComboBox implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            TypeWall type = (TypeWall) jComboBox.getSelectedItem();
            if(wall.getType() != type && switchListener != null){
                Wall newWall = factoryWall.copy(wall, type);
                System.out.println("SWITCH!");
                switchListener.switchObjects(wall, newWall);
                wall = newWall;
            }
        }
    }

    class ApplyListener implements ActionListener{
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
                    if(healthCurr > health) {
                        wall.setHealthPointCurrent((int) health);
                        tfHealthPointCurrent.setText(String.valueOf(wall.getHealthPoint()));
                    } else {
                        wall.setHealthPointCurrent((int) healthCurr);
                    }
                    wall.setHealthPoint((int) health);
                }
                btnApply.setForeground(Color.green.darker());
            } catch (NumberFormatException ex) {
                btnApply.setForeground(Color.red);

            }
        }
    }


}

package root.controllers.Editors;

import root.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorModel<T extends Model> extends JFrame {

    private JTextField tfWidth;
    private JTextField tfHeight;
    private JTextField tfX;
    private JTextField tfY;
    private JButton btnApply;


    protected T editObj;

    public EditorModel(String title) throws HeadlessException {
        super(title);


        setResizable(false);
        setSize(200, 300);
        setLayout(null);


//x
        JLabel labelX = new JLabel("x");
        labelX.setBounds(10, 10, 100, 10);
        add(labelX);

        tfX = new JTextField();
        tfX.setBounds(10, 20, 100, 30);
        add(tfX);


        //y
        JLabel labelY = new JLabel("y");
        labelY.setBounds(10, 55, 100, 10);
        add(labelY);

        tfY = new JTextField();
        tfY.setBounds(10, 65, 100, 30);
        add(tfY);

        //Width
        JLabel labelWidth = new JLabel("Width");
        labelWidth.setBounds(10,  100, 100, 10);
        add(labelWidth);

        tfWidth = new JTextField();
        tfWidth.setBounds(10, 110, 100, 30);
        add(tfWidth);


        //Heigth
        JLabel labelHeight = new JLabel("Height");
        labelHeight.setBounds(10, 145, 100, 10);
        add(labelHeight);

        tfHeight = new JTextField();
        tfHeight.setBounds(10, 155, 100, 30);
        add(tfHeight);


        btnApply = new JButton("применить");
        btnApply.setBounds(10, 200, 100, 50);
        add(btnApply);


        addApplyListener(new ActionListener() {
            double x;
            double y;
            double width;
            double height;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    width = Double.parseDouble(tfWidth.getText());
                    height = Double.parseDouble(tfHeight.getText());
                    x = Double.parseDouble(tfX.getText());
                    y = Double.parseDouble(tfY.getText());

                    editObj.setWidth(width);
                    editObj.setHeight(height);
                    editObj.setX(x);
                    editObj.setY(y);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

            }
        });




    }



    public void edit(T t){
        editObj = t;

        updateFrame(t);

        setVisible(true);
    }



    public void updateFrame(T model) {
        tfX.setText(String.valueOf(model.getX()));
        tfY.setText(String.valueOf(model.getY()));
        tfWidth.setText(String.valueOf(model.getWidth()));
        tfHeight.setText(String.valueOf(model.getHeight()));
    }




    public void addApplyListener(ActionListener actionListener){
        btnApply.addActionListener(actionListener);
    }





    public static void main(String[] args) {
        EditorModel editorModel = new EditorModel("model");
        editorModel.setVisible(true);
    }


    public JTextField getTfWidth() {
        return tfWidth;
    }

    public JTextField getTfHeight() {
        return tfHeight;
    }

    public JTextField getTfX() {
        return tfX;
    }

    public JTextField getTfY() {
        return tfY;
    }

    public JButton getBtnApply() {
        return btnApply;
    }
}

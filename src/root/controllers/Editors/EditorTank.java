package root.controllers.Editors;

import root.model.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditorTank<T extends Tank> extends EditorBreakableObject<T> {
    private JLabel speed;
    private JTextField tfSpeed;
    private JLabel damage;
    private JTextField tfDamage;
    private JLabel speedDamage;
    private JTextField tfSpeedDamage;

    public EditorTank(String title) throws HeadlessException {
        super(title);

        speed = new JLabel("Speed");
        speed.setBounds(250, 15, 100, 10);
        add(speed);

        tfSpeed = new JTextField();
        tfSpeed.setBounds(250, 25, 100, 30);
        add(tfSpeed);

        damage = new JLabel("Damage");
        damage.setBounds(250, 55, 100, 10);
        add(damage);

        tfDamage = new JTextField();
        tfDamage.setBounds(250, 65, 100, 30);
        add(tfDamage);

        speedDamage = new JLabel("SpeedDamage");
        speedDamage.setBounds(250, 100, 100, 10);
        add(speedDamage);

        tfSpeedDamage = new JTextField();
        tfSpeedDamage.setBounds(250, 110, 100, 30);
        add(tfSpeedDamage);




        getTfWidth().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                    getTfHeight().setText(getTfWidth().getText());
            }
        });

        getTfHeight().setEnabled(false);



       setSize(getWidth()+200, getHeight());

        addApplyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("edit Tank!");
            }
        });
    }


    public static void main(String[] args) {
        EditorTank<Tank> tankEditorTank = new EditorTank<>("tank");
        tankEditorTank.setVisible(true);
    }
}

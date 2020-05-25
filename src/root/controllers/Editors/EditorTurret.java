package root.controllers.Editors;

import root.model.Turret.Turret;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditorTurret<T extends Turret> extends EditorWall<T>{

    protected JLabel damage;
    protected JTextField tfDamage;
    protected JLabel coolDown;
    protected JTextField tfCoolDown;

    public EditorTurret(String title) {
        super(title);
        jcbDirection.setVisible(true);
        damage = new JLabel("Damage");
        damage.setBounds(250, 55, 100, 10);
        add(damage);

        tfDamage = new JTextField();
        tfDamage.setBounds(250, 65, 100, 30);
        add(tfDamage);

        coolDown = new JLabel("CoolDown(ms)");
        coolDown.setBounds(250, 100, 100, 10);
        add(coolDown);

        tfCoolDown = new JTextField();
        tfCoolDown.setBounds(250, 110, 100, 30);
        add(tfCoolDown);


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
                System.out.println("edit Turret!");
                int damage;
                int coolDown;
                damage = Integer.parseInt(tfDamage.getText());
                coolDown = Integer.parseInt(tfCoolDown.getText());
                editObj.setTimeCoolDown(coolDown);
                editObj.setDamage(damage);
            }

        });
    }




    @Override
    public void updateFrame(T model) {
        super.updateFrame(model);
        tfDamage.setText(String.valueOf(model.getDamage()));
        tfCoolDown.setText(String.valueOf(model.getTimeCoolDown()));
    }
}
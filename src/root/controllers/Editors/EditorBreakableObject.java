package root.controllers.Editors;

import root.model.BreakableObject;
import root.model.Direction;
import root.model.Wall.TypeObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EditorBreakableObject<T extends BreakableObject> extends EditorModel<T> {

    protected JLabel labelHealthPoint;
    protected JLabel healthPointCurrent;
    protected JTextField tfHealthPoint;
    protected JTextField tfHealthPointCurrent;

    protected JCheckBox cbUnbreakable;
    protected JComboBox<TypeObject> jcbType;
    protected JComboBox<Direction> jcbDirection;

    private SwitchListener<T> switchListener;

    private FactoryInterface<T> factoryObject;


    public EditorBreakableObject(String title) throws HeadlessException {
        super(title);


        setSize(300, 300);

        //HPCurrent
        healthPointCurrent = new JLabel("HPCurrent");
        healthPointCurrent.setBounds(140, 100, 100, 10);
        add(healthPointCurrent);


        tfHealthPointCurrent = new JTextField();
        tfHealthPointCurrent.setBounds(140, 110, 100, 30);
        add(tfHealthPointCurrent);
//HealthPoint
        labelHealthPoint = new JLabel("HealthPoint");
        labelHealthPoint.setBounds(140, 55, 100, 10);
        add(labelHealthPoint);


        tfHealthPoint = new JTextField();
        tfHealthPoint.setBounds(140, 65, 100, 30);
        add(tfHealthPoint);


        //is unbreakable
        cbUnbreakable = new JCheckBox("is unbreakable");
        cbUnbreakable.setBounds(140, 20, 100, 20);
        add(cbUnbreakable);

        cbUnbreakable.addActionListener(new CheckBoxListener());

        addApplyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double healthCurr;
                double health;
                if (!cbUnbreakable.isSelected()) {
                    healthCurr = Double.parseDouble(tfHealthPointCurrent.getText());
                    health = Double.parseDouble(tfHealthPoint.getText());
                    if(healthCurr > health) {
                        editObj.setHealthPointCurrent((int) health);
                        tfHealthPointCurrent.setText(String.valueOf(editObj.getHealthPoint()));
                    } else {
                        editObj.setHealthPointCurrent((int) healthCurr);
                    }
                    editObj.setHealthPoint((int) health);
                }
            }
        });



        TypeObject[] types = TypeObject.values();
        jcbType = new JComboBox<>(types);
        jcbType.setBounds(140,150,100,30);
        jcbType.addItemListener(new ChangeTypeListener());
        add(jcbType);

        Direction[] directions = Direction.values();
        jcbDirection = new JComboBox<>(directions);
        jcbDirection.setBounds(250,150,100,30);
        jcbDirection.addItemListener(new ChangeDirectionListener());
        add(jcbDirection);

    }


    @Override
    public void updateFrame(T model) {
        super.updateFrame(model);

        tfHealthPointCurrent.setText(String.valueOf(model.getHealthPointCurrent()));
        tfHealthPoint.setText(String.valueOf(model.getHealthPoint()));
        cbUnbreakable.setSelected(model.isUnbreakable());
        healthPointCurrent.setVisible(!cbUnbreakable.isSelected());
        labelHealthPoint.setVisible(!cbUnbreakable.isSelected());
        tfHealthPointCurrent.setVisible(!cbUnbreakable.isSelected());
        tfHealthPoint.setVisible(!cbUnbreakable.isSelected());

        jcbType.setSelectedItem(model.getType());
        jcbDirection.setSelectedItem(model.getDirection());


    }



    class CheckBoxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(cbUnbreakable.isSelected()) {
                editObj.setUnbreakable(true);
                System.out.println("action listener" + cbUnbreakable.isSelected());
                tfHealthPoint.setVisible(false);
                labelHealthPoint.setVisible(false);
                tfHealthPointCurrent.setVisible(false);
                healthPointCurrent.setVisible(false);

            }else{
                editObj.setUnbreakable(false);
                System.out.println("action listener" + cbUnbreakable.isSelected());
                tfHealthPoint.setVisible(true);
                labelHealthPoint.setVisible(true);
                tfHealthPointCurrent.setVisible(true);
                healthPointCurrent.setVisible(true);
            }
        }
    }

    class ChangeDirectionListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            Direction direction = (Direction) jcbDirection.getSelectedItem();
            editObj.setDirection(direction);
        }
    }


    class ChangeTypeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            TypeObject type = (TypeObject) jcbType.getSelectedItem();
            if(editObj.getType() != type && switchListener != null && factoryObject != null){
                T newObj = factoryObject.getInstance(type, editObj.getLocation(), editObj.getDimension());
                switchListener.switchObjects(editObj, newObj);
                editObj = newObj;
                updateFrame(newObj);
            }
        }
    }



    public JTextField getTfHealthPoint() {
        return tfHealthPoint;
    }

    public JTextField getTfHealthPointCurrent() {
        return tfHealthPointCurrent;
    }

    public JCheckBox getCbUnbreakable() {
        return cbUnbreakable;
    }

    public void setSwitchListener(SwitchListener<T> listener){
        switchListener = listener;
    }


    public void setFactoryObject(FactoryInterface<T> factoryObject) {
        this.factoryObject = factoryObject;
    }


    public JComboBox<TypeObject> getJcbType() {
        return jcbType;
    }

    public static void main(String[] args) {
        EditorBreakableObject  editorBreakableObject = new EditorBreakableObject("bo");
        editorBreakableObject.setVisible(true);
    }
}

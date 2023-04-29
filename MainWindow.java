package Challange2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow{

    protected Frame frame;
    private JButton btnOk, btnCancel;
    protected JComboBox cbOptions;

    protected int convertorOption;

    public MainWindow(){
        frame = new Frame("Menu Principal");
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        addLabel("Seleccione un conversor");
        addOkButton("Ok");
        addCancelButton("Salir");

        addComboBox();
        addComboBoxOptions("Convertir moneda");
        addComboBoxOptions("Convertir temperatura");
    }

    protected void addLabel(String labelText){
        Label label1 = new Label(labelText);
        label1.setBounds(50,60,300,30);
        frame.add(label1);
    }

    protected void addComboBox(){
        cbOptions = new JComboBox<String>();
        cbOptions.setBounds(50,100,300,30);
        frame.add(cbOptions);
    }

    protected void addComboBoxOptions(String option){
        cbOptions.addItem(option);
    }

    protected void addOkButton(String text){
        btnOk = new JButton(text);
        btnOk.setBounds(90,150,100,30);

        frame.add(btnOk);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okButtonAction();
            }
        };

        btnOk.addActionListener(actionListener);

    }

    protected void addCancelButton(String text){
        btnCancel = new JButton(text);
        btnCancel.setBounds(210,150,100,30);

        frame.add(btnCancel);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonAction();
            }
        };

        btnCancel.addActionListener(actionListener);
    }

    public void okButtonAction() {
        closeWindow();
        convertorOption = cbOptions.getSelectedIndex();

        InputWindow inputWindow = new InputWindow(convertorOption);
        System.out.println(convertorOption);

        inputWindow.showWindow();
    }

    public void cancelButtonAction(){
        closeWindow();
    }

    public void showWindow(){
        frame.setVisible(true);
    }

    public void closeWindow(){
        frame.dispose();
    }
}

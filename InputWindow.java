package Challange2;

import javax.swing.*;
import java.awt.*;

public class InputWindow extends MainWindow {
    private JTextField txtAmount;
    private float amount = 0;

    public InputWindow(int convertorOption){
        this.convertorOption = convertorOption;
        frame = new Frame("Menu Input");
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        if(convertorOption == 0){
            addLabel("Ingrese el monto");
        }else{
            addLabel("Ingrese los grados");
        }

        addTextField();
        addOkButton("Ok");
        addCancelButton("Regresar");
    }

    public void addTextField(){
        txtAmount = new JTextField();
        txtAmount.setBounds(50,100,300,30);
        frame.add(txtAmount);
    }

    @Override
    public void okButtonAction(){
        super.closeWindow();

        try{
            amount = Float.valueOf(txtAmount.getText());

            ConvertorWindow convertorWindow = new ConvertorWindow(amount, convertorOption);
            System.out.println(convertorOption);
            convertorWindow.showWindow();

        }catch (NumberFormatException e){
            super.closeWindow();

            InputWindow inputWindow = new InputWindow(convertorOption);
            inputWindow.showWindow();
            JOptionPane.showMessageDialog(frame,"Debe ingresar solo numeros");
        }
    }

    @Override
    public void cancelButtonAction(){
        super.closeWindow();

        MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
    }

}

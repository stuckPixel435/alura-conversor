package Challange2;


import javax.swing.*;
import java.awt.*;

public class ConvertorWindow extends MainWindow{

    private float amount;
    public ConvertorWindow(float amount, int convertorOption){
        this.convertorOption = convertorOption;
        frame = new Frame("Menu Conversor");
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        addAmountLabel(amount);
        this.amount = amount;

        addLabel("Seleccione una Opcion");
        addOkButton("Ok");
        addCancelButton("Regresar");

        addComboBox();
        addConvertorOptions(convertorOption);
    }
    private void addConvertorOptions(int option){
        if(option == 0){
            addComboBoxOptions("Convertir soles a dolares");
            addComboBoxOptions("Convertir soles a euros");
            addComboBoxOptions("Convertir soles a pesos mexicanos");
        }else{
            addComboBoxOptions("Convertir celsius a fahrenheit");
            addComboBoxOptions("Convertir celsius a kelvin");
            addComboBoxOptions("Convertir fahrenheit a celsius");
            addComboBoxOptions("Convertir kelvin a celsius");
        }
    }
    protected void addAmountLabel(float amount){
        Label mountLabel = new Label("Monto Ingresado: "+ amount);
        mountLabel.setBounds(50,40,300,30);
        frame.add(mountLabel);
    }

    @Override
    public void okButtonAction(){
        int optionSelected = cbOptions.getSelectedIndex();
        System.out.println(convertorOption);

        float totalAmount = 0;

        if(convertorOption == 0){
            totalAmount = amount * currencySelected(optionSelected);
        }else{
            totalAmount = temperatureSelected(optionSelected);
        }

        JOptionPane.showMessageDialog(frame,"Total: " +totalAmount);

        int option = JOptionPane.showConfirmDialog(frame, "¿Desea continuar?");

        finalOption(option);


    }

    @Override
    public void cancelButtonAction(){

        super.closeWindow();

        InputWindow inputWindow = new InputWindow(convertorOption);
        inputWindow.showWindow();
    }

    private float currencySelected(int optionSelected){
        switch (optionSelected){
            case 0: return Currency.DOLARES.getCurrency();
            case 1: return Currency.EUROS.getCurrency();
            case 2: return Currency.PESOS_MEXICANOS.getCurrency();
            default: return 0.0f;
        }
    }
    private float temperatureSelected(int optionSelected){
        switch (optionSelected){
            case 0: return Temperature.celsiusToFahrenheit(amount);
            case 1: return Temperature.celsiusToKelvin(amount);
            case 2: return Temperature.fahrenheitToCelsius(amount);
            case 3: return Temperature.kelvinToCelsius(amount);
            default: return 0.0f;
        }
    }

    private void finalOption(int option){
        switch (option){
            case 0: super.closeWindow();
                MainWindow mainWindow = new MainWindow();
                mainWindow.showWindow();
                break;
            case 1: super.closeWindow();
                JOptionPane.showMessageDialog(frame, "Programa finalizado");
                System.exit(0);
                break;
        }
    }
}

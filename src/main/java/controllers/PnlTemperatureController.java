package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import view.views.panel.pnlConversionTemplate;

/**
 *
 * @author Usuario
 */
public class PnlTemperatureController implements ActionListener {

    private pnlConversionTemplate pnlConversionTemplate;
    private final String TEMPERATURES[] = new String[]{"Celcius","Fahrenheit"};
    private DefaultComboBoxModel fromCmbModel;
    private DefaultComboBoxModel toCmbModel;

    public PnlTemperatureController(pnlConversionTemplate pnlConversionTemplate) {
        this.pnlConversionTemplate = pnlConversionTemplate;
        initComponent();
    }

    private void initComponent() {
        fromCmbModel = new DefaultComboBoxModel(TEMPERATURES);
        toCmbModel = new DefaultComboBoxModel(TEMPERATURES);
        pnlConversionTemplate.getCmbFrom().setModel(toCmbModel);
        pnlConversionTemplate.getCmbTo().setModel(toCmbModel);

        pnlConversionTemplate.getBtnCalcular().addActionListener(this);
        pnlConversionTemplate.getBtnNew().addActionListener(this);
        
        pnlConversionTemplate.getCmbFrom().addItemListener((ItemEvent e) -> {
            conversionEvent();
        });
        
        pnlConversionTemplate.getCmbTo().addItemListener((ItemEvent e) -> {
            conversionEvent();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Convertir")) {
            conversionEvent();
        }
    }

    private void conversionEvent() throws NumberFormatException {
        int cmbFromIndex = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
        int cmbToIndex = pnlConversionTemplate.getCmbTo().getSelectedIndex();
        double value = Double.parseDouble(pnlConversionTemplate.getTxtResultado().getText());
        
        pnlConversionTemplate.getLblResult().setText("Resultado" + convertidorTemperature(value, cmbFromIndex, cmbToIndex));
    }

    private double convertidorTemperature(double value, int from, int to) {
        switch (from) {
            case 0:
                switch (to) {
                    case 0:
                        return value;
                    case 1:
                        return celciusToFahrenheit(value);
                }
            case 1:
                switch (to) {
                    case 0:
                        return fahrenheitToCelcius(value);
                    case 1:
                        return value;
                }
        }
        return value;
    }

    private double celciusToFahrenheit(double value) {
        return ((9 / 5 * value) + 32);
    }

    private double fahrenheitToCelcius(double value) {
        return ((value - 32) * 5 / 9);
    }
}
    
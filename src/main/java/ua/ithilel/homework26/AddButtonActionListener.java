package ua.ithilel.homework26;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ua.ithilel.homework26.CalculatorConstants.ERROR_MASSAGE;

public class AddButtonActionListener implements ActionListener {

    private final JTextField input;

    public AddButtonActionListener(JTextField input) {
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (input.getText().contains(ERROR_MASSAGE)) input.setText("");
        var actionBtn = (JButton) e.getSource();
        input.setText(input.getText() + actionBtn.getText());
    }
}

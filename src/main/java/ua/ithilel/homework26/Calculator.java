package ua.ithilel.homework26;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Calculator implements ActionListener {

    private final JTextField input;

    public Calculator(JTextField input) {
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] operant = input.getText().split("[^0-9]");
        List<String> opr = new ArrayList<>();
        for (String opration : input.getText().split("[^\\+,\\-,\\/,\\*]")) {
            opr.add(opration);
        }
        opr.removeAll(Collections.singleton(""));

        int constan = Integer.parseInt(operant[0]);
        for (int i = 1; i < operant.length; i++) {
            constan = calc(constan, Integer.parseInt(operant[i]), opr.get(i - 1));
        }
        input.setText(String.valueOf(constan));
    }


    public int calc(int num1, int num2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}

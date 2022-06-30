package ua.ithilel.homework26;

import javax.swing.*;
import java.awt.*;

public class BasicApplicationFrame {

    private final JFrame mainFrame = new JFrame();

    public BasicApplicationFrame() {
        mainFrame.setTitle("Basic Application");
        mainFrame.setBounds(100, 70, 300, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());


        var top = new JPanel();
        top.setLayout(new BorderLayout());
        var inputField = new JTextField();
        AddButtonActionListener addButtonActionListener = new AddButtonActionListener(inputField);

        Calculator calculator = new Calculator(inputField);
        inputField.setEditable(false);
        top.add(inputField, BorderLayout.CENTER);
        mainFrame.add(top, BorderLayout.NORTH);


        var bottom = new JPanel();
        bottom.setLayout(new GridLayout(6, 3));
        mainFrame.add(bottom, BorderLayout.CENTER);

        var acBtn = new JButton("AC");
        acBtn.addActionListener(event -> inputField.setText(""));
        bottom.add(acBtn);

        var plusBtn = new JButton("+");
        bottom.add(plusBtn);
        plusBtn.addActionListener(addButtonActionListener);

        var subtractionBtn = new JButton("-");
        bottom.add(subtractionBtn);
        subtractionBtn.addActionListener(addButtonActionListener);


        var multiplicationBtn = new JButton("*");
        bottom.add(multiplicationBtn);
        multiplicationBtn.addActionListener(addButtonActionListener);


        var divisionBtn = new JButton("/");
        bottom.add(divisionBtn);
        divisionBtn.addActionListener(addButtonActionListener);


        var squareBtn = new JButton("√");
        bottom.add(squareBtn);
        squareBtn.addActionListener(event -> {
            double square = Math.sqrt(Integer.parseInt(inputField.getText()));
            inputField.setText(String.valueOf(square));
        });

        var calculatorBtn = new JButton("=");
        bottom.add(calculatorBtn);
        calculatorBtn.addActionListener(calculator);

        for (int i = 0; i <= 9; i++) {
            var btn = new JButton(String.valueOf(i));
            bottom.add(btn);
            btn.addActionListener(addButtonActionListener);
        }
        mainFrame.setVisible(true);
    }
}

package com.v360.view;

import com.v360.controller.TodolistController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SubTaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane subtaskField;
    private JButton deleteButton;

    public JTextPane getSubTaskField() {
        return subtaskField;
    }
    
    private JPanel parentPanel;
        
        public SubTaskComponent(JPanel parentPanel, String descricao){
        this.parentPanel = parentPanel;

        subtaskField = new JTextPane();
        subtaskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        subtaskField.setPreferredSize(CommonConstants.SUBTASKFIELD_SIZE);
        subtaskField.setContentType("text/html");
        subtaskField.setText(descricao);  
        subtaskField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                subtaskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                subtaskField.setBackground(null);
            }
        });

        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);

        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);

        add(checkBox);
        add(subtaskField);
        add(deleteButton);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            String taskText = subtaskField.getText().replaceAll("<[^>]*>", "");

            subtaskField.setText("<html><s>"+ taskText + "</s></html>");
        }else if(!checkBox.isSelected()){
            String taskText = subtaskField.getText().replaceAll("<[^>]*>", "");

            subtaskField.setText(taskText);
        }

        if (e.getActionCommand().equalsIgnoreCase("X")) {
        String taskText = subtaskField.getText();

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\((\\d+)\\)\\((\\d+)\\)");
        java.util.regex.Matcher matcher = pattern.matcher(taskText);

        if (matcher.find()) {
            String codigo1 = matcher.group(1);
            String codigo2 = matcher.group(2);

            int numero1 = Integer.parseInt(codigo1);
            int numero2 = Integer.parseInt(codigo2);

            System.out.println("Número 1: " + numero1);
            System.out.println("Número 2: " + numero2);
            
            TodolistController.removerSubTarefa(numero1, numero2, UserloginView.getEmailLogado());

        }
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }

    }
}

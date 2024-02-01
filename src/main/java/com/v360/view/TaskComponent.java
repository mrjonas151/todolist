package com.v360.view;

import com.v360.controller.TodolistController;
import com.v360.model.TodolistModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;
    private JButton editButton;
    private static int codigoTaskPrincipal=0;

    public static int getCodigoTaskPrincipal() {
        return codigoTaskPrincipal;
    }

    public static void setCodigoTaskPrincipal(int codigoTaskPrincipal) {
        TaskComponent.codigoTaskPrincipal = codigoTaskPrincipal;
    }

    public JTextPane getTaskField() {
        return taskField;
    }
    
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel, String descricao){
        this.parentPanel = parentPanel;

        taskField = new JTextPane();
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        taskField.setText(descricao);
        taskField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                taskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);
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
        
        editButton = new JButton("+");
        editButton.setPreferredSize(CommonConstants.ADD_SUBTASK_BUTTON_SIZE);
        editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editButton.addActionListener(this);

        add(checkBox);
        add(taskField);
        add(deleteButton);
        add(editButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText("<html><s>" + taskText + "</s></html>");
        } else if (!checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }

        if (e.getActionCommand().equalsIgnoreCase("X")) {
            String taskText = taskField.getText();

            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\((\\d+)\\)");
            java.util.regex.Matcher matcher = pattern.matcher(taskText);

            if (matcher.find()) {
                String codigo = matcher.group(1);
                int numero = Integer.parseInt(codigo);
                System.out.println("Número: " + numero);

                TodolistController.removerTarefa(numero, UserloginView.getEmailLogado());

                removerTarefaVisualmente(this, parentPanel, numero);
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("+")) {
            String taskText = taskField.getText();

            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\((\\d+)\\)");
            java.util.regex.Matcher matcher = pattern.matcher(taskText);

            if (matcher.find()) {
                String codigo = matcher.group(1);
                int numero = Integer.parseInt(codigo);
                System.out.println("Número: " + numero);
                codigoTaskPrincipal = numero;
                
                Container parentContainer = getParent();


                TodolistView todolistView = findTodolistViewAncestor(this);

                if (todolistView != null) {
                    todolistView.setVisible(false);
                    new SubtaskcreateView().setVisible(true);
                }
            }
    
        }
    }
    
    private TodolistView findTodolistViewAncestor(Component component) {
    while (component != null) {
        if (component instanceof TodolistView) {
            return (TodolistView) component;
        }
        component = component.getParent();
    }
    return null;
}

    private void removerTarefaVisualmente(Component component, JPanel parentPanel, int numeroTarefa) {
        parentPanel.remove(component);
        parentPanel.repaint();
        parentPanel.revalidate();

        TodolistView todolistView = (TodolistView) SwingUtilities.getWindowAncestor(parentPanel);
        todolistView.atualizarTarefasSemMouse(TodolistController.pesquisarListas(UserloginView.getEmailLogado()));
    }  
}

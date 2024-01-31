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
    

    // this panel is used so that we can make updates to the task component panel when deleting tasks
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel, String descricao){
        this.parentPanel = parentPanel;

        // task field
        taskField = new JTextPane();
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        taskField.setText(descricao);
        taskField.addFocusListener(new FocusListener() {
            // indicate which task field is currently being edited
            @Override
            public void focusGained(FocusEvent e) {
                taskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);
            }
        });

        
       
        // checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);
        
        //editar button
        editButton = new JButton("+");
        editButton.setPreferredSize(CommonConstants.ADD_SUBTASK_BUTTON_SIZE);
        editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editButton.addActionListener(this);

        // add to this taskcomponent
        add(checkBox);
        add(taskField);
        add(deleteButton);
        add(editButton);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(checkBox.isSelected()){
//            // replaces all html tags to empty string to grab the main text
//            String taskText = taskField.getText().replaceAll("<[^>]*>", "");
//
//            // add strikethrough text
//            taskField.setText("<html><s>"+ taskText + "</s></html>");
//        }else if(!checkBox.isSelected()){
//            String taskText = taskField.getText().replaceAll("<[^>]*>", "");
//
//            taskField.setText(taskText);
//        }
//
//        if (e.getActionCommand().equalsIgnoreCase("X")) {
//            String taskText = taskField.getText();
//
//            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\((\\d+)\\)");
//            java.util.regex.Matcher matcher = pattern.matcher(taskText);
//
//            if (matcher.find()) {
//                String codigo = matcher.group(1);
//                int numero = Integer.parseInt(codigo);
//                System.out.println("Número: " + numero);
//                TodolistController.removerTarefa(numero, UserloginView.getEmailLogado());
//                TodolistView view = new TodolistView();
//                java.util.List<TodolistModel> tarefasAtt = new ArrayList();
//                tarefasAtt = TodolistController.pesquisarListas(UserloginView.getEmailLogado());
//                view.atualizarTarefasSemMouse(tarefasAtt);
//            }
//            
//            parentPanel.remove(this);
//            parentPanel.repaint();
//            parentPanel.revalidate();
//        }
//        
//        if (e.getActionCommand().equalsIgnoreCase("+")) {
//            String taskText = taskField.getText();
//
//            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\((\\d+)\\)");
//            java.util.regex.Matcher matcher = pattern.matcher(taskText);
//
//            if (matcher.find()) {
//                String codigo = matcher.group(1);
//                int numero = Integer.parseInt(codigo);
//                System.out.println("Número: " + numero);
//                codigoTaskPrincipal = numero;
//                
//                new SubtaskcreateView().setVisible(true);
//            }
//        }
//
//    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            // replaces all html tags to empty string to grab the main text
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            // add strikethrough text
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

                // Remover a tarefa e suas subtarefas do banco de dados
                TodolistController.removerTarefa(numero, UserloginView.getEmailLogado());

                // Remover visualmente a tarefa e suas subtarefas
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

        // Atualizar visualmente as tarefas após a remoção
        TodolistView todolistView = (TodolistView) SwingUtilities.getWindowAncestor(parentPanel);
        todolistView.atualizarTarefasSemMouse(TodolistController.pesquisarListas(UserloginView.getEmailLogado()));
    }

    
}

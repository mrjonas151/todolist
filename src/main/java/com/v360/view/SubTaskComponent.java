package com.v360.view;

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

    // this panel is used so that we can make updates to the task component panel when deleting tasks
    private JPanel parentPanel;
        
        public SubTaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;

        // subtask field
        subtaskField = new JTextPane();
        subtaskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        subtaskField.setPreferredSize(CommonConstants.SUBTASKFIELD_SIZE);
        subtaskField.setContentType("text/html");
        subtaskField.addFocusListener(new FocusListener() {
            // indicate which task field is currently being edited
            @Override
            public void focusGained(FocusEvent e) {
                subtaskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                subtaskField.setBackground(null);
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

        // add to this taskcomponent
        add(checkBox);
        add(subtaskField);
        add(deleteButton);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            // replaces all html tags to empty string to grab the main text
            String taskText = subtaskField.getText().replaceAll("<[^>]*>", "");

            // add strikethrough text
            subtaskField.setText("<html><s>"+ taskText + "</s></html>");
        }else if(!checkBox.isSelected()){
            String taskText = subtaskField.getText().replaceAll("<[^>]*>", "");

            subtaskField.setText(taskText);
        }

        if(e.getActionCommand().equalsIgnoreCase("X")){
            // delete this component from the parent panel
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}

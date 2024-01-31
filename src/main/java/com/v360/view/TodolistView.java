/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.v360.view;

import com.v360.controller.TodolistController;
import com.v360.dao.TodolistDAO;
import com.v360.model.TarefaModel;
import com.v360.model.TodolistModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

/**
 *
 * @author jonas
 */
public final class TodolistView extends javax.swing.JFrame {

    List<TodolistModel> tarefas = new ArrayList();
    private JPanel taskPanel, taskComponentPanel ,subTaskPanel, subTaskComponentPanel;
    
    /**
     * Creates new form UsercadastroView
     */
    public TodolistView() {
        super("Aplicacao to do list");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        getContentPane().setBackground(new Color(137, 216, 230));

        setLayout(null);

        addGuiComponents();
        initComponents();
    }
    
    public void addGuiComponents() {
    // taskpanel
    taskPanel = new JPanel();
    subTaskPanel = new JPanel();

    // Novo painel para conter taskComponentPanel e subTaskComponentPanel
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    // taskcomponentpanel
    taskComponentPanel = new JPanel();
    taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
    taskPanel.add(taskComponentPanel);

    //subtask componentpanel
    subTaskComponentPanel = new JPanel();
    subTaskComponentPanel.setLayout(new BoxLayout(subTaskComponentPanel, BoxLayout.Y_AXIS));
    subTaskPanel.add(subTaskComponentPanel);

    // Adiciona taskPanel e subTaskPanel ao novo painel
    mainPanel.add(taskPanel);
    mainPanel.add(subTaskPanel);

    // add scrolling to the task panel
    JScrollPane scrollPane = new JScrollPane(mainPanel);
    scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
    scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
    scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // changing the speed of the scroll bar
    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    verticalScrollBar.setUnitIncrement(20);

    this.getContentPane().add(scrollPane);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btAtualizarTarefas = new javax.swing.JButton();
        addTaskButton = new javax.swing.JButton();
        addSubTaskButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 149));
        jButton1.setText("+");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 3, 44)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 139));
        jLabel4.setText("TAREFAS");

        btVoltar.setBackground(new java.awt.Color(247, 247, 247));
        btVoltar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(0, 0, 139));
        btVoltar.setText("Sair");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });

        btAtualizarTarefas.setBackground(new java.awt.Color(247, 247, 247));
        btAtualizarTarefas.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        btAtualizarTarefas.setForeground(new java.awt.Color(0, 0, 139));
        btAtualizarTarefas.setText("ATUALIZAR TAREFAS");
        btAtualizarTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAtualizarTarefasMouseClicked(evt);
            }
        });
        btAtualizarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarTarefasActionPerformed(evt);
            }
        });

        addTaskButton.setText("Add Task");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        addSubTaskButton.setText("Add Subtask");
        addSubTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(addTaskButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAtualizarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addSubTaskButton)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addComponent(addTaskButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSubTaskButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        int escolha = JOptionPane.showConfirmDialog(null, "Deseja realmente sair da aplicação?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (escolha == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
    }//GEN-LAST:event_btVoltarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        new TaskcreateView().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        // create a task component
//        TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
//        taskComponentPanel.add(taskComponent);
//
//        // make the previous task appear disabled
//        if (taskComponentPanel.getComponentCount() > 1) {
//            TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(
//                    taskComponentPanel.getComponentCount() - 2);
//            previousTask.getTaskField().setBackground(null);
//        }
//
//        taskComponent.getTaskField().requestFocus();
//        repaint();
//        revalidate();
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void addSubTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubTaskButtonActionPerformed
//        //create a task component
//        SubTaskComponent subtaskComponent = new SubTaskComponent(subTaskComponentPanel);
//        subTaskComponentPanel.add(subtaskComponent);
//
//        // make the previous task appear disabled
//        if (subTaskComponentPanel.getComponentCount() > 1) {
//            SubTaskComponent previousTask = (SubTaskComponent) subTaskComponentPanel.getComponent(
//                    subTaskComponentPanel.getComponentCount() - 2);
//            previousTask.getSubTaskField().setBackground(null);
//        }
//        subtaskComponent.getSubTaskField().requestFocus();
//        repaint();
//        revalidate();
    }//GEN-LAST:event_addSubTaskButtonActionPerformed

    private void exibirTarefas(List<TodolistModel> tarefas) {
        taskComponentPanel.removeAll(); // Limpa todos os componentes existentes no painel

        if (tarefas != null) {
            for (TodolistModel tarefa : tarefas) {
                String descricao = tarefa.getListName();
                TaskComponent taskComponent = new TaskComponent(taskComponentPanel, descricao);
                taskComponentPanel.add(taskComponent);

                // Configura o texto do campo da tarefa com o nome da tarefa
                //taskComponent.getTaskField().setText(tarefa.getListName());

                // Recupera e exibe as subtarefas desta tarefa
                List<TarefaModel> subtarefas = TodolistDAO.pesquisarSubTarefas(tarefa.getListId(), UserloginView.getEmailLogado());
                if (subtarefas != null) {
                    for (TarefaModel subtarefa : subtarefas) {
                        String descricaoSub = subtarefa.getDescricao();
                        SubTaskComponent subtaskComponent = new SubTaskComponent(subTaskComponentPanel, descricaoSub);
                        subTaskComponentPanel.add(subtaskComponent);

                        // Configura o texto do campo da subtarefa com a descrição da subtarefa
                        //subtaskComponent.getSubTaskField().setText(subtarefa.getDescricao());
                    }
                }
            }
        }

        repaint();
        revalidate();
    }
    
    private void btAtualizarTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtualizarTarefasMouseClicked
        atualizarTarefas(UserloginView.getEmailLogado());
        exibirTarefas(tarefas);
    }//GEN-LAST:event_btAtualizarTarefasMouseClicked

    private void btAtualizarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarTarefasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAtualizarTarefasActionPerformed

    
//    public void actionPerformed(ActionEvent e) {
//        String command = e.getActionCommand();
//        if(command.equalsIgnoreCase("Add Task")){
//            // create a task component
//            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
//            taskComponentPanel.add(taskComponent);
//
//            // make the previous task appear disabled
//            if(taskComponentPanel.getComponentCount() > 1){
//                TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(
//                        taskComponentPanel.getComponentCount() - 2);
//                previousTask.getTaskField().setBackground(null);
//            }
//        }else if(command.equalsIgnoreCase("Add Subtask")){
//            SubTaskComponent subtaskComponent = new SubTaskComponent(subTaskComponentPanel);
//            subTaskComponentPanel.add(subtaskComponent);
//            if(subTaskComponentPanel.getComponentCount() > 1){
//                SubTaskComponent previousTask = (SubTaskComponent) subTaskComponentPanel.getComponent(
//                        subTaskComponentPanel.getComponentCount() - 2);
//                previousTask.getSubTaskField().setBackground(null);
//            }
//        }
//    }
    
    public void atualizarTarefas(String email){
        tarefas = null;
        tarefas = TodolistController.pesquisarListas(email);
    }
    
    public void removerTarefa(int listId, String email){
        //Fazer a logica aqui
    }
    
    public void removerSubTarefa(int listId, int itemId, String email){
        //fazer a logica aqui
    }
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TodolistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TodolistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TodolistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TodolistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TodolistView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSubTaskButton;
    private javax.swing.JButton addTaskButton;
    private javax.swing.JButton btAtualizarTarefas;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

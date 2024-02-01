package com.v360.view;

import com.v360.controller.TodolistController;
import com.v360.dao.TodolistDAO;
import com.v360.model.TarefaModel;
import com.v360.model.TodolistModel;
import java.awt.Color;
import java.awt.Component;
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

public final class TodolistView extends javax.swing.JFrame {

    List<TodolistModel> tarefas = new ArrayList();
    private JPanel taskPanel, taskComponentPanel ,subTaskPanel, subTaskComponentPanel;
    
    public List<TodolistModel> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TodolistModel> tarefas) {
        this.tarefas = tarefas;
    }
    
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
        
        atualizarTarefas(UserloginView.getEmailLogado());
        exibirTarefas(tarefas);
    }
    
    public void addGuiComponents() {
    taskPanel = new JPanel();
    subTaskPanel = new JPanel();

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    taskComponentPanel = new JPanel();
    taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
    taskPanel.add(taskComponentPanel);

    subTaskComponentPanel = new JPanel();
    subTaskComponentPanel.setLayout(new BoxLayout(subTaskComponentPanel, BoxLayout.Y_AXIS));
    subTaskPanel.add(subTaskComponentPanel);

    mainPanel.add(taskPanel);
    mainPanel.add(subTaskPanel);

    JScrollPane scrollPane = new JScrollPane(mainPanel);
    scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
    scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
    scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    verticalScrollBar.setUnitIncrement(20);

    this.getContentPane().add(scrollPane);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btAtualizarTarefas = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAtualizarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addComponent(btAtualizarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void exibirTarefas(List<TodolistModel> tarefas) {
        taskComponentPanel.removeAll(); // Limpa todos os componentes existentes no painel
        subTaskComponentPanel.removeAll();

        if (tarefas != null) {
            for (TodolistModel tarefa : tarefas) {
                String descricao = "(" + tarefa.getListId() + ") " + tarefa.getListName() + "   [" +tarefa.getData()+"]";
                TaskComponent taskComponent = new TaskComponent(taskComponentPanel, descricao);
                taskComponentPanel.add(taskComponent);

                List<TarefaModel> subtarefas = TodolistDAO.pesquisarSubTarefas(tarefa.getListId(), UserloginView.getEmailLogado());
                if (subtarefas != null) {
                    for (TarefaModel subtarefa : subtarefas) {
                        String descricaoSub = "(" + subtarefa.getList_id() + ")" + "(" + subtarefa.getId() + ") " + subtarefa.getDescricao() +"   [" + subtarefa.getData() + "]";
                        SubTaskComponent subtaskComponent = new SubTaskComponent(subTaskComponentPanel, descricaoSub);
                        subTaskComponentPanel.add(subtaskComponent);
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

    public void atualizarTarefasSemMouse(List<TodolistModel> listaTarefas){
        tarefas = null;
        tarefas = TodolistController.pesquisarListas(UserloginView.getEmailLogado());
        exibirTarefas(listaTarefas);
    }
    
    private void btAtualizarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarTarefasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAtualizarTarefasActionPerformed

    public void atualizarTarefas(String email){
        tarefas = null;
        tarefas = TodolistController.pesquisarListas(email);
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
    private javax.swing.JButton btAtualizarTarefas;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

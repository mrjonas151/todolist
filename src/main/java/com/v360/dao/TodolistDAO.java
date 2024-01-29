package com.v360.dao;

import com.v360.model.TarefaModel;
import com.v360.model.TodolistModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodolistDAO {
    
    public static boolean criarTarefa(TodolistModel tarefa, String email){

        Connection conn = ConexaoBD.getConnection();

        String query = "INSERT INTO lists VALUES (null, ?, ?)";
        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, tarefa.getListName());
    
            pstm.execute();
            pstm.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("ERRO DAO " + erro);
            }
        
        return false;
    }
    
    public static boolean criarSubTarefa(TarefaModel tarefa, String email){
        Connection conn = ConexaoBD.getConnection();

        String query = "INSERT INTO items VALUES (null, ?, ?, ?, null)";
        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setInt(2, tarefa.getList_id());
            pstm.setString(3, tarefa.getDescricao());
    
            pstm.execute();
            pstm.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("ERRO DAO " + erro);
            }
        
        return false;
    }
    
    public static List<TodolistModel> pesquisarListas(String email) {
        Connection conn = ConexaoBD.getConnection();
        String query = "SELECT * FROM lists WHERE email = ?";
        PreparedStatement pstm;
        ResultSet rs;

        List<TodolistModel> listaToDo = new ArrayList<>();

        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            rs = pstm.executeQuery();

            while (rs.next()) {
                TodolistModel tarefa = new TodolistModel();
                tarefa.setListId(rs.getInt("list_id"));
                tarefa.setUserEmail(email);
                tarefa.setListName(rs.getString("list_name"));

                listaToDo.add(tarefa);
            }

        } catch (SQLException erro) {
            System.out.println("ERRO DAO " + erro);
        }

        return listaToDo;
    }
    
    public static List<TarefaModel> pesquisarSubTarefas(int list_id, String email) {
        Connection conn = ConexaoBD.getConnection();
        String query = "SELECT * FROM lists WHERE list_id = ?";
        PreparedStatement pstm;
        ResultSet rs;

        List<TarefaModel> listaSubTarefas = new ArrayList<>();

        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, list_id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                TarefaModel tarefa = new TarefaModel();
                tarefa.setId(rs.getInt("item_id"));
                tarefa.setUser_email(email);
                tarefa.setList_id(rs.getInt("list_id"));
                tarefa.setConcluida(false);

                listaSubTarefas.add(tarefa);
            }

        } catch (SQLException erro) {
            System.out.println("ERRO DAO " + erro);
        }

        return listaSubTarefas;
    }
}

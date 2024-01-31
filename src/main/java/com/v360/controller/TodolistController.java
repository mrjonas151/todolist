package com.v360.controller;

import com.v360.dao.TodolistDAO;
import com.v360.model.TarefaModel;
import com.v360.model.TodolistModel;
import java.util.ArrayList;
import java.util.List;

public class TodolistController {
    
    public static boolean criarTarefa(String descricao, String email){
        TodolistModel tarefa = new TodolistModel(descricao);
        
        if(TodolistDAO.criarTarefa(tarefa, email)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean criarSubTarefa(String descricao, String email){
        TarefaModel tarefa = new TarefaModel(descricao);
        
        if(TodolistDAO.criarSubTarefa(tarefa, email)){
            return true;
        }else{
            return false;
        }
    }
    
    public static List<TodolistModel> pesquisarListas(String email){
        List<TodolistModel> listaToDo = new ArrayList<>();
        
        if(TodolistDAO.pesquisarListas(email) != null){
            listaToDo = TodolistDAO.pesquisarListas(email);
        }else{
            listaToDo = null;
        }
        
        return listaToDo;
    }
    
    public static List<TarefaModel> pesquisarSubTarefas(int list_id, String email){
        List<TarefaModel> subTarefas = new ArrayList<>();

        List<TarefaModel> resultadosDAO = TodolistDAO.pesquisarSubTarefas(list_id, email);

        if(resultadosDAO != null && !resultadosDAO.isEmpty()){
            subTarefas = resultadosDAO;
        }

        return subTarefas;
    }
    
    public static boolean removerTarefa(int listId, String email) {
        return TodolistDAO.removerTarefa(listId, email);
    }

    public static boolean removerSubTarefa(int listId, int itemId, String email) {
        return TodolistDAO.removerSubTarefa(listId, itemId, email); 
    }

}

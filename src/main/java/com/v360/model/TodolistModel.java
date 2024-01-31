package com.v360.model;

import java.util.List;

public class TodolistModel {
    private int listId;
    private String userEmail;
    private String listName;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    private List<TarefaModel> items;
    

    public TodolistModel(String listName, String data) {
        this.listName = listName;
        this.data = data;
    }
    
    public TodolistModel() {
        this.listName = listName;
    }
    
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<TarefaModel> getItems() {
        return items;
    }

    public void setItems(List<TarefaModel> items) {
        this.items = items;
    }
}

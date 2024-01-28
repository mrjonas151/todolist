package com.v360.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexaoBD {

    private static Connection conn;

    private static ConexaoBD conexao;

    public ConexaoBD() {
        conectaBD();
    }

    public static ConexaoBD getConexao() {
        if (conexao == null) {
            conexao = new ConexaoBD();
        }
        return conexao;
    }

    public static Connection getConnection() {
        if(conn==null){
            conectaBD();
        }
        return conn;
    }

    public ResultSet executarQueryBD(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar");
        }
        return resultSet;
    }

    public static void conectaBD() {
        String url = "jdbc:mysql://localhost:3306/todolist";
        String username = "root";
        String password = "password";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar " + e);
        }
    }
}
package com.v360.dao;

import com.v360.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean criarContaBD(UserModel user){
        Connection conn = ConexaoBD.getConnection();

        String query = "INSERT INTO users VALUES (?, ?)";
        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());
    
            pstm.execute();
            pstm.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("ERRO DAO " + erro);
            }
        
        return false;
    }
    
    public static boolean logarUsuarioBD(String email, String password) {
    try {
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
        pstm.setString(1, email);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        return rs.next();
    } catch (SQLException erro) {
        erro.printStackTrace();
        System.out.println("ERRO DAO " + erro);
    }

    return false;
}
    
    public static boolean pesquisarUsuarioBD(String email) {
    try {
        System.out.println("passou4");
        Connection conn = ConexaoBD.getConnection();
        System.out.println("passou5");
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
        System.out.println("passou6");
        pstm.setString(1, email);
        ResultSet rs = pstm.executeQuery();
        return rs.next();
    } catch (SQLException erro) {
        erro.printStackTrace();
        System.out.println("ERRO DAO " + erro);
    }

        return false;
    }

}

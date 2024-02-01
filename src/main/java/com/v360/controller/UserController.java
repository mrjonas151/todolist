package com.v360.controller;

import com.v360.dao.UserDAO;
import com.v360.model.UserModel;

public class UserController {
    
    public static String criarConta(String email, String password){
        UserModel novoUsuario = new UserModel();
        
        novoUsuario.setEmail(email);
        novoUsuario.setPassword(password);
        
        if(UserDAO.pesquisarUsuarioBD(email)){
            System.out.println("com.v360.controller.UserController.criarConta()");
            return "Email já existente, Experimente fazer login";
        }else{
            if (UserDAO.criarContaBD(novoUsuario)) {
                System.out.println("com.v360.controller.UserController.criarConta()");
                return "Cadastro concluído com sucesso, faça seu login!";
            } else {
                System.out.println("com.v360.controller.UserController.criarConta()");
                return "Erro no cadastro!";
            }
        }
        
    }
    
    public static boolean logarUsuario(String email, String password) {
        if (UserDAO.logarUsuarioBD(email, password)) {
            return true;
        } else {
            return false;
        }
    }
}

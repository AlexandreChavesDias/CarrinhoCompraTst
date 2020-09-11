package com.sysc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bdcarrinhocompra";
    String user="root";
    String pass="";    
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO " + e);
        }
        return con;
    }
}
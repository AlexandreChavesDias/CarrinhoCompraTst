
package com.sysc.modelo;


public class Cliente {
    
    private int id;
    private String dni;
    private  String nome;
    private String direccao;
    private  String email;
    private String password;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nome, String direccao, String email, String password) {
        this.id = id;
        this.dni = dni;
        this.nome = nome;
        this.direccao = direccao;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDireccao() {
        return direccao;
    }

    public void setDireccao(String direccao) {
        this.direccao = direccao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

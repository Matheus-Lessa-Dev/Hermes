/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author mathe
 */
public class Usuario {
    private int id;
    private String gmail;
    private String senha;
    private String nome;
    private double peso; // Usando double para valores decimais
    private int altura;
    private int gorduraCorporal;
    private boolean administrador;

    // Construtor vazio
    public Usuario() {
    }

    public Usuario(int id, String gmail, String senha) {
        this.id = id;
        this.gmail = gmail;
        this.senha = senha;
    }

    // Construtor com parâmetros
    public Usuario(int id, String gmail, String senha, String nome, double peso, int altura, int gorduraCorporal, boolean administrador) {
        this.id = id;
        this.gmail = gmail;
        this.senha = senha;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.administrador = administrador;
    }

    public Usuario(String gmail, String senha, String nome, double peso, int altura, int gorduraCorporal, boolean administrador) {
        this.gmail = gmail;
        this.senha = senha;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.administrador = administrador;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getGorduraCorporal() {
        return gorduraCorporal;
    }

    public void setGorduraCorporal(int gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

}


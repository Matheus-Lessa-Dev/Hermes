/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author mathe
 */
public class Imagem {
  
    private int id; // Chave primária
    private int idExercicio; // Chave estrangeira para Exercicio
    private int idMusculo; // Chave estrangeira para Musculo
    private int idConcienciaCorporal; // Chave estrangeira para ConcienciaCorporal
    private String descricao;
    private String caminho;

    // Construtor padrão
    public Imagem() {
    }
/* da erro pois tem 2 construtores com os "mesmos" parametros.
    public Imagem(int id, int idConcienciaCorporal, String descricao, String caminho) {
        this.id = id;
        this.idConcienciaCorporal = idConcienciaCorporal;
        this.descricao = descricao;
        this.caminho = caminho;
    }*/
    public Imagem(int id, int idMusculo, String descricao, String caminho) {
        this.id = id;
        this.idMusculo = idMusculo;
        this.descricao = descricao;
        this.caminho = caminho;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public int getIdMusculo() {
        return idMusculo;
    }

    public void setIdMusculo(int idMusculo) {
        this.idMusculo = idMusculo;
    }

    public int getIdConcienciaCorporal() {
        return idConcienciaCorporal;
    }

    public void setIdConcienciaCorporal(int idConcienciaCorporal) {
        this.idConcienciaCorporal = idConcienciaCorporal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}



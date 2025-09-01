/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author mathe
 */
public class ExercicioMusculo {
    
    private int id; // Chave primária
    private int idExercicio; // Chave estrangeira para Exercicio
    private int idMusculo; // Chave estrangeira para Musculo

    public ExercicioMusculo() {
    }

    public ExercicioMusculo(int idExercicio, int idMusculo) {
        this.idExercicio = idExercicio;
        this.idMusculo = idMusculo;
    }

    public ExercicioMusculo(int id, int idExercicio, int idMusculo) {
        this.id = id;
        this.idExercicio = idExercicio;
        this.idMusculo = idMusculo;
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
    
    
}

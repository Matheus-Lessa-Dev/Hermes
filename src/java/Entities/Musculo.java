package Entities;


public class Musculo {
    private int ID;
    private String Nome;
    private String descricao;

    public Musculo(int ID, String Nome, String descricao) {
        this.ID = ID;
        this.Nome = Nome;
        this.descricao = descricao;
    }

    public Musculo(String Nome, String descricao) {
        this.Nome = Nome;
        this.descricao = descricao;
    }
    
    public Musculo(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}

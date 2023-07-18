package kauaMarques.banco;

public class Pessoa {
    private final String nome;
    private final int CPF;

    public Pessoa(String nome, int CPF){
        this.nome = nome;
        this.CPF = CPF;
    }

    public int getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }
}

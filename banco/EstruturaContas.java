package kauaMarques.banco;

public interface EstruturaContas {
    public abstract void inserir(Conta nova) throws ContaCadastrada;
    public abstract Conta pesquisar(int numero) throws ContaInexistente;
}

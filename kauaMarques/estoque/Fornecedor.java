package kauaMarques.estoque;

public class Fornecedor {
    private final long cnpj;
    private final String nome;

    public Fornecedor(long cnpj, String nome){
        this.cnpj = cnpj;
        this.nome = nome;
    }


    public long getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }
}

package kauaMarques.estoqueComProdutoPerecivel;

public class Fornecedor {
    private final int cnpj;
    private final String nome;

    public Fornecedor(int cnpj, String nome){
        this.cnpj = cnpj;
        this.nome = nome;
    }


    public int getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }
}

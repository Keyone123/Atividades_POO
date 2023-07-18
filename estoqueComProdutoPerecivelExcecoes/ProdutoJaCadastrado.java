package kauaMarques.estoqueComProdutoPerecivelExcecoes;

public class ProdutoJaCadastrado extends Exception{
    public ProdutoJaCadastrado(int cod){
        System.out.println("\nO produto de código " + cod + " já foi cadastrado anteriormente");
    }
}

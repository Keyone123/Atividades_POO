package kauaMarques.estoqueComProdutoPerecivelExcecoes;

public class ProdutoNaoPerecivel extends Exception{
    public ProdutoNaoPerecivel(int cod){
        System.out.println("\nO produto de código " + cod + " não é perecivel");
    }
}

package kauaMarques.estoqueComProdutoPerecivelExcecoes;

public class ProdutoInexistente extends Exception{
    public ProdutoInexistente(int cod){
        System.out.println("\nO produto de código " + cod + " não existe");
    }
}

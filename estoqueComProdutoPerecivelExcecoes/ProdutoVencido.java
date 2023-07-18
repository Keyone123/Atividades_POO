package kauaMarques.estoqueComProdutoPerecivelExcecoes;
public class ProdutoVencido extends Exception{
    public ProdutoVencido(int cod){
        System.out.println("\nO produto de código " + cod + " está vencido");
    }
}

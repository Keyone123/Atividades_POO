package kauaMarques.estoqueComProdutoPerecivelExcecoes;

import java.util.ArrayList;
import java.util.Date;

public interface InterfaceEstoqueComExcecoes {
    public void incluir(Produto novo) throws ProdutoJaCadastrado, DadosInvalidos, ProdutoInexistente;
    public void comprar(int cod, int quant, double preco, Date val)  throws ProdutoInexistente, DadosInvalidos, ProdutoNaoPerecivel;
    public double vender(int cod, int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos;
    public Produto pesquisar (int cod) throws ProdutoInexistente;
    public ArrayList<Produto> estoqueAbaixoDoMinimo();
    public ArrayList<Produto> estoqueVencido();
    public int quantidadeVencidos(int cod) throws ProdutoInexistente;

}

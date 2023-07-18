package kauaMarques.estoqueComProdutoPerecivelExcecoes;
import java.util.ArrayList;
import java.util.Date;

public class Estoque implements InterfaceEstoqueComExcecoes{
    private final ArrayList<Produto> produtos = new ArrayList<>();

    public void incluir(Produto novo) throws ProdutoJaCadastrado, DadosInvalidos {
        if(novo.getCodigo() <= 0 || novo.getLucro() <= 0 || novo.getDescricao() == null || novo.getEstoqueMinimo() <= 0)
            throw new DadosInvalidos();
        else{
            for(Produto aux : produtos){
                if(aux.getCodigo() == novo.getCodigo())
                    throw new ProdutoJaCadastrado(novo.getCodigo());
            }
        }
        produtos.add(novo);
    }
    public void comprar(int cod, int quant, double preco, Date data) throws DadosInvalidos, ProdutoNaoPerecivel, ProdutoInexistente {
        if(cod <= 0 || quant <= 0 || preco <= 0){
            throw new DadosInvalidos();
        }
        else if(data == null){
            for(Produto aux : produtos){
                if(aux == pesquisar(cod)){
                    System.out.println("\nProduto encontrado");
                    aux.compra(quant, preco);
                    break;
                }
            }
        }else{
            for(Produto aux : produtos){
                if(aux == pesquisar(cod)){
                    if(aux instanceof ProdutoPerecivel){
                        ((ProdutoPerecivel) aux).compra_perecivel(quant, preco, data);
                    }
                    else{
                        throw new ProdutoNaoPerecivel(aux.getCodigo());
                    }
                }
            }
        }
    }
    public double vender(int cod, int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos{
        if(cod <= 0 || quant < 0){
            throw new DadosInvalidos();
        }
        for(Produto aux : produtos){
            if(aux.getCodigo() == 0){
                if(aux instanceof ProdutoPerecivel)
                    return ((ProdutoPerecivel) aux).venda_perecivel(cod, quant);
                else
                    return aux.venda(quant);
            }
        }
        throw new ProdutoInexistente(cod);
    }
    public Produto pesquisar(int cod) throws ProdutoInexistente{
        for(Produto aux : produtos){
            if(aux.getCodigo() == cod){
                return aux;
            }
        }
        throw new ProdutoInexistente(cod);
    }
    public ArrayList<Produto> estoqueAbaixoDoMinimo(){
        ArrayList<Produto> aux = new ArrayList<>();
        if(produtos.size() == 0){
            System.out.println("\nNão há nenhum produto cadastrado");
        }else {
            for (Produto auxiliar : produtos)
                if (auxiliar.listar_produtos_minimo())
                    aux.add(auxiliar);
        }
        return aux;
    }
    public int quantidade(long cod){
        if(produtos.size() == 0){
            System.out.println("\nNão há nenhum produto cadastrado");
        }else {
            for (Produto aux : produtos) {
                if (aux.getCodigo() == cod) {
                    System.out.println("\nProduto encontrado!!!");
                    return aux.getQuantidade();
                }
            }
        }
        System.out.println("\nProduto não encontrado!!!");
        return -1;
    }
    public Fornecedor achar_fornecedor(long cod){
        if(produtos.size() == 0){
            System.out.println("\nNão há nenhum produto cadastrado");
        }else {
            for (Produto aux : produtos) {
                if (aux.getCodigo() == cod) {
                    System.out.println("\nFornecedor encontrado!!!");
                    return aux.getFornecedor();
                }
            }
        }
        System.out.println("\nFornecedor não encontrado");
        return null;
    }
    public ArrayList<Produto> estoqueVencido(){
        Date hoje = new Date();
        ArrayList<Produto> lista = new ArrayList<>();
        ArrayList<Lote> lotes = new ArrayList<>();
        for(Produto aux : produtos){
            if(aux instanceof ProdutoPerecivel){
                lotes = ((ProdutoPerecivel) aux).getLotes();
            }
            for(Lote lt : lotes){
                if(lt.getVencimento().before(hoje)){
                    lista.add(aux);
                    break;
                }
            }
        }
        return lista;
    }
    public int quantidadeVencidos(int cod) throws ProdutoInexistente{
        int quant = 0;
        Date hoje =  new Date();

        for(Produto prod: produtos) {
            if(prod instanceof ProdutoPerecivel && prod.getCodigo() == cod) {
                ArrayList<Lote> listaLotes = ((ProdutoPerecivel) prod).getLotes();
                for(Lote lt: listaLotes) {
                    if (lt.getVencimento().before(hoje)) {
                        quant++;
                        break;
                    }
                }
                return quant;
            }
        }
        throw new ProdutoInexistente(cod);
    }
    public void mostrar_produtos(){
        for(Produto aux : produtos){
            System.out.println("Nome: " + aux.getDescricao());
        }
    }
}

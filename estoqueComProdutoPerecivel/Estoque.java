package kauaMarques.estoqueComProdutoPerecivel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Estoque {
    private final ArrayList<Produto> produtos = new ArrayList<>();

    public boolean incluir(Produto novo){
        if(novo == null)
            return false;
        if(novo.getCodigo() < 0 || Objects.equals(novo.getDescricao(), "     ") || novo.getLucro() < 0 || novo.getCNPJ() <= 0)
            return false;
        else {
            if(pesquisar(novo.getCodigo()) == null){
                produtos.add(novo);
                return true;
            }
        }
        return false;
    }
    public boolean comprar(long cod, int quant, double preco, Date data){
        Date hoje = new Date();
        if(cod < 0 || quant < 0 || preco < 0){
            System.out.println("\nDados cadastrados inválidos");
            return false;
        }
        if(data == null){
            for(Produto aux : produtos){
                if(aux.getCodigo() == cod){
                    System.out.println("\nProduto encontrado");
                    aux.compra(quant, preco);
                    return true;
                }
            }
        }else{
            if(data.before(hoje))
                return false;
            for(Produto aux : produtos){
                if(aux.getCodigo() == cod){
                    if(aux instanceof ProdutoPerecivel){
                        ((ProdutoPerecivel) aux).comprar(quant, preco, data);
                        return true;
                    }
                    else{
                        System.out.println("\nEsse produto não é um produto perecivel");
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public double vender(long cod, int quant){
        if(cod <= 0 || quant < 0){
            System.out.println("\nValores inválidos");
            return -1;
        }
        for(Produto aux : produtos){
            if(aux.getCodigo() == cod){
                if(aux instanceof ProdutoPerecivel)
                    return ((ProdutoPerecivel) aux).vender(cod, quant);
                else
                    return aux.vender(quant);
            }
        }
        return -1;
    }
    public Produto pesquisar(long cod){
        for(Produto aux : produtos){
            if(aux.getCodigo() == cod){
                return aux;
            }
        }
        return null;
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
    public int quantidadeVencidos(int cod) {
        int quant = 0;
        Date hoje =  new Date();

        for(Produto prod: produtos) {
            if(prod instanceof ProdutoPerecivel) {
                ArrayList<Lote> listaLotes = ((ProdutoPerecivel) prod).getLotes();

                for(Lote lt: listaLotes) {
                    if (lt.getVencimento().before(hoje)) {
                        quant++;
                        break;
                    }
                }

            }
        }

        return quant;
    }
    public void mostrar_produtos(){
        for(Produto aux : produtos){
            System.out.println("Nome: " + aux.getDescricao());
        }
    }
}
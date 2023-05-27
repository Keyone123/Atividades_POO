package kauaMarques.estoque;
import java.util.ArrayList;
public class Estoque {
    private final ArrayList<Produto> produtos = new ArrayList<>();

    public void incluir(Produto novo){
        boolean verificar = true;
        for(Produto aux : produtos){
            if(aux.getCodigo() == novo.getCodigo()){
                verificar = false;
                break;
            }
        }if(verificar){
            produtos.add(novo);
            System.out.println("\nProduto cadastrado com sucesso!!!");
        }else
            System.out.println("\nCódigo desse produto já foi cadastrado");

    }

    public void compra(long cod, int quant, double valor){
        if(quant <= 0 || valor <= 0){
            System.out.println("\nQuantidade ou preço inválidos, tente novamente");
            return;
        }
        if(produtos.size() == 0){
            System.out.println("\nNão há nenhum produto cadastrado");
        }else {
            for (Produto aux : produtos) {
                if(aux.getCodigo() == cod) {
                    System.out.println("\nProduto encontrado!!!");
                    aux.compra(quant, valor);
                }
            }
        }
    }

    public double venda(long cod, int quant){
        if(quant <= 0){
            System.out.println("Quantidade inválida, tente novamente");
            return 0;
        }
        if(produtos.size() == 0){
            System.out.println("\nNão há nenhum produto cadastrado");
            return 0;
        }else{
            for(Produto aux : produtos){
                if(aux.getCodigo() == cod){
                    System.out.println("\nProduto encontrado!!!\n");
                    return aux.venda(quant);
                }
            }
        }
        System.out.println("\nProduto não foi encontrado");
        return 0;
    }

    public ArrayList<Produto> listar_produtos_abaixo_minimo(){
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

    public void listar_produtos(){
        int i = 1;
        for(Produto aux : produtos){
            System.out.println("\nProduto " + i + ":");
            System.out.println("Código: " + aux.getCodigo());
            System.out.println("Descrição: " + aux.getDescricao());
            System.out.println("Quantidade: " + aux.getQuantidade());
            System.out.println("Preço de compra: " + aux.getPreco_compra());
            System.out.println("Lucro: " + aux.getLucro());
            System.out.println("Preço de venda: " + aux.getPreco_venda());
            i++;
        }
    }

}

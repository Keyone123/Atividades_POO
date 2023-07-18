package kauaMarques.estoqueComProdutoPerecivelExcecoes;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto {
    ArrayList<Lote> lotes = new ArrayList<>();
    public ProdutoPerecivel(int codigo, String descricao, int estoque_minimo, double lucro, Fornecedor fornecedor) {
        super(codigo, descricao, estoque_minimo, lucro, fornecedor);
    }
    public void compra_perecivel(int quant, double valor, Date data){
        int quantidade_antiga = this.quantidade;
        double aux;
        this.quantidade += quantidade;
        preco_compra = (quantidade_antiga * preco_compra + quantidade * valor)/this.quantidade;
        aux = preco_compra * lucro;
        preco_venda = aux + preco_compra;
        Lote pro = new Lote(quant, data);
        lotes.add(pro);
    }
    public double venda_perecivel(int cod, int quant) throws ProdutoVencido{
        Date hoje = new Date();
        int inicial = quant;
        Date menor = new Date(hoje.getYear()+100);
        while(quant > 0){
            Lote atual = lotes.get(0);
            for(Lote aux : lotes){
                if(aux.getVencimento().before(menor)){
                    menor = aux.getVencimento();
                    atual = aux;
                }
            }
            if(atual.getVencimento().before(hoje))
                throw new ProdutoVencido(cod);
            if(atual.getQuantidade() == quant){
                quant = 0;
                atual.setQuantidade(0);
                lotes.remove(atual);
            }else if(atual.getQuantidade() > quant){
                quant = 0;
                atual.setQuantidade(atual.getQuantidade() - quant);
            }
            else if(atual.getQuantidade() < quant){
                quant -= atual.getQuantidade();
                atual.setQuantidade(0);
                lotes.remove(atual);
            }
        }
        return inicial*preco_venda;
    }
    public ArrayList<Lote> getLotes() {
        return lotes;
    }
}


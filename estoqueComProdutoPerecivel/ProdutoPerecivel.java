package kauaMarques.estoqueComProdutoPerecivel;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto{
    ArrayList<Lote> lotes = new ArrayList<>();
    public ProdutoPerecivel(long codigo, String descricao, int estoque_minimo, int lucro, Fornecedor fornecedor) {
        super(codigo, descricao, estoque_minimo, lucro, fornecedor);
    }
    public void comprar(int quant, double valor, Date data){
        int quantidade_antiga = this.quantidade;
        double aux;
        this.quantidade += quantidade;
        preco_compra = (quantidade_antiga * preco_compra + quantidade * valor)/this.quantidade;
        aux = preco_compra * lucro;
        preco_venda = aux + preco_compra;
        Lote pro = new Lote(quant, data);
        lotes.add(pro);
    }
    public double vender(long cod, int quant){
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
            if(atual.getVencimento().before(hoje)){
                System.out.println("\nO produto em questão está vencido");
                return -1;
            }
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
        return this.lotes;
    }
}

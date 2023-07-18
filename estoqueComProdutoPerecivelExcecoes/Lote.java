package kauaMarques.estoqueComProdutoPerecivelExcecoes;
import java.util.Date;

public class Lote {
    private int quantidade;
    private final Date vencimento;

    public Lote(int quantidade, Date vencimeto){
        this.quantidade = quantidade;
        this.vencimento = vencimeto;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

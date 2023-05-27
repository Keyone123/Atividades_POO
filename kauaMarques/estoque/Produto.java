package kauaMarques.estoque;

public class Produto {
    private final long codigo;
    private final String descricao;
    private double preco_compra;
    private double preco_venda;
    private final double lucro;
    private int quantidade;
    private final int estoque_minimo;
    private final Fornecedor fornecedor;

    public Produto(long codigo, String descricao, int estoque_minimo, double lucro, Fornecedor fornecedor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.estoque_minimo = estoque_minimo;
        this.lucro = lucro;
        this.fornecedor = fornecedor;
    }

    public void compra(int quantidade, double valor){
        int quant_antiga = this.quantidade;
        double aux;
        this.quantidade += quantidade;
        preco_compra = (quant_antiga * preco_compra + quantidade * valor)/this.quantidade;
        aux = preco_compra * lucro;
        preco_venda = aux + preco_compra;
    }

    public double venda(int quant_venda){
        if(quantidade == 0){
            System.out.println("Venda não autorizada, o estoque está baixo");
            return -1;
        }else{
            quantidade -= quant_venda;
            return quant_venda * preco_venda;
        }
    }
    public boolean listar_produtos_minimo(){
        return quantidade < estoque_minimo;
    }

    public long getCodigo() {
        return codigo;
    }


    public String getDescricao() {
        return descricao;
    }


    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public double getLucro() {
        return lucro;
    }

    public double getPreco_venda() {
        return preco_venda;
    }
}

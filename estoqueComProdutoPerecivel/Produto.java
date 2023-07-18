package kauaMarques.estoqueComProdutoPerecivel;

public class Produto {
    protected final long codigo;
    protected final String descricao;
    protected double preco_compra;
    protected double preco_venda;
    protected final double lucro;
    protected int quantidade;
    protected final int estoque_minimo;
    protected final Fornecedor fornecedor;

    public Produto(long codigo, String descricao, int estoque_minimo, int lucro, Fornecedor fornecedor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.estoque_minimo = estoque_minimo;
        this.lucro = (double) lucro /10;
        this.fornecedor = fornecedor;
        this.preco_venda = 0;
        this.preco_compra = 0;
        this.quantidade = 0;
    }

    public void compra(int quantidade, double valor){
        this.quantidade += quantidade;
        this.preco_compra = (this.quantidade * this.preco_compra + quantidade * valor) / (this.quantidade + quantidade);
        preco_venda = (preco_compra * lucro) + preco_compra;
    }

    public double vender(int quant_venda){
        if(quantidade <= 0){
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

    public int getEstoque_minimo(){
        return estoque_minimo;
    }
    public int getCNPJ(){
        return fornecedor.getCnpj();
    }
}

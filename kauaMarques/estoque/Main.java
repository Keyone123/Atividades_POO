package kauaMarques.estoque;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static int menu(){
        Scanner input = new Scanner(System.in);
        int resp;
        System.out.println("\n------------------ Mini Menu ------------------");
        System.out.println("1.Cadastrar Produto no Estoque");
        System.out.println("2.Cadastrar produto perecivel");
        System.out.println("3.Comprar Produto");
        System.out.println("4.Vender Produto");
        System.out.println("5.Pesquisar Produto");
        System.out.println("6.Listar produtos com estoque abaixo");
        System.out.println("7.Mostrar quantidade de um Produto");
        System.out.println("8.Mostrar Fornecedor de um Produto");
        System.out.println("9.Mostrar estoque de vencidos");
        System.out.println("10.Mostrar quantidade de vencidos");
        System.out.println("11.Mostrar produtos");
        System.out.println("0.Sair");
        System.out.println("\n-----------------------------------------------");
        System.out.print("Digite a sua opção: ");
        resp = input.nextInt();
        return resp;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean igual = true;
        Estoque produtos = new Estoque();
        while(igual){
            int op = menu();
            switch(op){
                case 1 ->{
                    Fornecedor tudo = new Fornecedor(1905, "Ricardão Tudos");
                    Produto produto = new Produto(1, "Coca Cola", 150, 30, tudo);
                    Produto produto1 = new Produto(2, "Arroz", 200, 25, tudo);
                    Produto produto2 = new Produto(3, "Feijão", 500, 50, tudo);
                    Produto produto3 = new Produto(4, "Pica", 100, 10, tudo);
                    Produto produto4 = new Produto(5, "Papel", 1000, 15, tudo);
                    Produto produto5 = new Produto(6, "Computador", 25, 50, tudo);
                    produtos.incluir(produto);
                    produtos.incluir(produto1);
                    produtos.incluir(produto2);
                    produtos.incluir(produto3);
                    produtos.incluir(produto4);
                    produtos.incluir(produto5);
                }
                case 2 ->{
                    Fornecedor tudo = new Fornecedor(1905, "Ricardão Tudos");
                    ProdutoPerecivel prod = new ProdutoPerecivel(7, "Melão", 50, 50, tudo);
                    ProdutoPerecivel prod1 = new ProdutoPerecivel(8, "Morango", 100, 30, tudo);
                    ProdutoPerecivel prod2 = new ProdutoPerecivel(9, "Tomate", 200, 40, tudo);
                    ProdutoPerecivel prod3 = new ProdutoPerecivel(1, "Teste", 300, 10, tudo);
                    produtos.incluir(prod);
                    produtos.incluir(prod1);
                    produtos.incluir(prod2);
                    produtos.incluir(prod3);
                }
                case 3 ->{
                    int rp, cod, quant;
                    double valor;
                    System.out.println("\nEscolha qual opção (1.Produto 2.Produto Perecivel): ");
                    rp = input.nextInt();
                    if(rp == 1){
                        System.out.println("\nDigite os valores: ");
                        cod = input.nextInt();
                        quant = input.nextInt();
                        valor = input.nextDouble();
                        if(produtos.comprar(cod, quant, valor, null))
                            System.out.println("\nProduto comprado com sucesso");
                        else
                            System.out.println("\nProduto não pode ser comprado");
                    }else if(rp == 2){
                        System.out.println("\nDigite os valores: ");
                        cod = input.nextInt();
                        quant = input.nextInt();
                        valor = input.nextDouble();
                        Date hoje = new Date();
                        hoje.setYear(2030);
                        hoje.setDate(20);
                        hoje.setMonth(Calendar.DECEMBER);
                        if(produtos.comprar(cod, quant, valor, hoje))
                            System.out.println("\nProduto comprado com sucesso");
                        else
                            System.out.println("\nProduto não pode ser comprado");
                    }
                }
                case 4 ->{
                    int cod, quant;
                    System.out.println("\nDigite os valores: ");
                    cod = input.nextInt();
                    quant = input.nextInt();
                    System.out.println("\nValor da compra: " + produtos.vender(cod, quant));
                }
                case 5 -> {
                    int cod;
                    System.out.println("\nDigite os valores: ");
                    cod = input.nextInt();
                    System.out.println("\nProduto: " + produtos.pesquisar(cod).getDescricao());
                }
                case 6 -> System.out.println("\nResultado: " + produtos.listar_produtos_abaixo_minimo());
                case 7 ->{
                    int cod;
                    System.out.println("\nDigite os valores: ");
                    cod = input.nextInt();
                    System.out.println("\nQuantidade de produtos: " + produtos.quantidade(cod));
                }
                case 8 -> {
                    int cod;
                    System.out.println("\nDigite os valores: ");
                    cod = input.nextInt();
                    System.out.println("\nFornecedor: " + produtos.achar_fornecedor(cod).getNome());
                }
                case 9 -> System.out.println("\nEstoque: " + produtos.estoque_vencido());
                case 10 -> {
                    int cod;
                    System.out.println("\nDigite os valores: ");
                    cod = input.nextInt();
                    System.out.println("\nResultado: " + produtos.quantidadeVencidos(cod));
                }
                case 11 -> produtos.mostrar_produtos();
                case 0 -> igual = false;
            }
        }
    }
}

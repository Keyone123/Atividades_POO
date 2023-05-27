package kauaMarques.estoque;

import java.util.Scanner;

public class Main {
    public static int menu(){
        Scanner input = new Scanner(System.in);
        int resp;
        System.out.println("\n------------------ Mini Menu ------------------");
        System.out.println("1.Cadastrar Produto no Estoque");
        System.out.println("2.Comprar Produto");
        System.out.println("3.Vender Produto");
        System.out.println("4.Listar Produtos com estoque abaixo");
        System.out.println("5.Listar todos os Produtos");
        System.out.println("6.Mostrar quantidade de um Produto");
        System.out.println("7.Mostrar Fornecedor de um Produto");
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
                    System.out.println("\nCadastre o fornecedor do produto:");
                    System.out.print("Digite o CNPJ: ");
                    long cnpj = Long.parseLong(input.nextLine());
                    System.out.print("Digite o nome do fornecedor: ");
                    String nome = input.nextLine();
                    Fornecedor novo = new Fornecedor(cnpj, nome);
                    System.out.println("\nAgora, cadastre o produto no estoque:");
                    System.out.print("Digite o código do produto: ");
                    long cod = Long.parseLong(input.nextLine());
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = input.nextLine();
                    System.out.print("Digite a quantidade de estoque minimo: ");
                    int minimo = input.nextInt();
                    System.out.print("Digite o lucro do produto(Em decimal): ");
                    double lucro = input.nextDouble();
                    Produto produto = new Produto(cod, descricao, minimo, lucro, novo);
                    produtos.incluir(produto);
                }
                case 2 ->{
                    System.out.print("Digite o código que será pesquisado: ");
                    long cod = input.nextLong();
                    System.out.print("Digite a quantidade que será comprada: ");
                    int quantidade = input.nextInt();
                    System.out.print("Digite o preço de compra do produto: ");
                    double compra = input.nextDouble();
                    produtos.compra(cod, quantidade, compra);
                }
                case 3 ->{
                    System.out.print("Digite o código que será pesquisado: ");
                    long cod = input.nextLong();
                    System.out.print("Digite a quantidade que será vendida: ");
                    int quantidade = input.nextInt();
                    System.out.print("O valor da compra deu: " + produtos.venda(cod, quantidade));
                }
                case 4 -> System.out.println(produtos.listar_produtos_abaixo_minimo());
                case 5 -> produtos.listar_produtos();
                case 6 ->{
                    System.out.print("Digite o código que será pesquisado: ");
                    long cod = input.nextLong();
                    System.out.println("Quantidade: " + produtos.quantidade(cod));
                }
                case 7 ->{
                    System.out.print("Digite o código que será pesquisado: ");
                    long cod = input.nextLong();
                    System.out.println("Fornecedor: " + produtos.achar_fornecedor(cod));
                }
                case 0 -> igual = false;
            }
        }
    }
}

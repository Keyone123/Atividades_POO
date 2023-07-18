package kauaMarques.banco;

public class ContaCadastrada extends Exception{
    public ContaCadastrada(int numero){
        System.out.println("\nA conta com número " + numero + " já foi cadastrada anteriormente");
    }
}

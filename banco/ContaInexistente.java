package kauaMarques.banco;

public class ContaInexistente extends Exception{
    public ContaInexistente(int numero){
        System.out.println("\nA conta com número " + numero + " não existe");
    }
}

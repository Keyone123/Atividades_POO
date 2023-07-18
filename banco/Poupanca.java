package kauaMarques.banco;

public class Poupanca extends ContaComum{
    public Poupanca(int numero, Pessoa dono){
        super(numero, dono);
    }
    public void juros(double porcento){
        porcento *= saldo;
        credito(porcento);
    }
}

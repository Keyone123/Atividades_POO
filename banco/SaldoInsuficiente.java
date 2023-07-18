package kauaMarques.banco;

public class SaldoInsuficiente extends Exception{
    public SaldoInsuficiente(int num, double valor){
        System.out.println("\nA operação não pode ser completada.\nSaldo da conta " + num + "é: " + valor);
    }
}

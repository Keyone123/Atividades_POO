package kauaMarques.banco;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected String extrato;
    protected Pessoa dono;

    public Conta(int numero, Pessoa dono){
        this.numero = numero;
        this.dono = dono;
    }

    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }
    public String getExtrato(){
        return extrato;
    }
    public Pessoa getDono(){
        return dono;
    }
    public void setNumero(int num){
        if(num > 0)
            this.numero = num;
        else
            System.out.println("\nNúmero inválido");
    }
    public void credito(double valor){
        saldo += valor;
        extrato += "Crédito: " + valor + " " + "Saldo: " + saldo + "\n";
    }
    public abstract void debito(double valor) throws SaldoInsuficiente;
}

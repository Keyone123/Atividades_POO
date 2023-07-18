package kauaMarques.banco;

public class ContaEspecial extends Conta{
    protected double limite;
    public ContaEspecial(int numero, Pessoa dono, double limite){
        super(numero, dono);
        this.limite = limite;
    }
    public void debito(double valor) throws SaldoInsuficiente{
        if(saldo + limite >= valor){
            saldo -= valor;
            extrato += "Débito de: " + valor + " " + "Saldo: " + saldo + "\n";
        }else
            throw new SaldoInsuficiente(this.numero, valor);
    }
}

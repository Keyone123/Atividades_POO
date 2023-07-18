package kauaMarques.banco;

public class ContaComum extends Conta{
    public ContaComum(int numero, Pessoa Dono){
        super(numero, Dono);
    }
    public ContaComum(int numero){
        super(numero, null);
        Pessoa nova = new Pessoa("Kauã", 1905);
    }
    public void debito(double valor) throws SaldoInsuficiente{
        if(saldo >= valor){
            saldo -= valor;
            extrato += "Débito de: " + valor + " " + "Saldo: " + saldo + "\n";
        }else
            throw new SaldoInsuficiente(this.numero, valor);
    }
}

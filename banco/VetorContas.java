package kauaMarques.banco;

import java.util.ArrayList;

public class VetorContas implements EstruturaContas{
    ArrayList<Conta> contas = new ArrayList<>();
    public void inserir(Conta nova) throws ContaCadastrada{
        Conta aux;
        try {
            aux = pesquisar(nova.getNumero());
            throw new ContaCadastrada(nova.getNumero());
        }catch (ContaInexistente e){
            contas.add(nova);
        }
    }
    public Conta pesquisar(int num) throws ContaInexistente{
        for(Conta aux : contas){
            if(aux.getNumero() == num)
                return aux;
        }
        throw  new ContaInexistente(num);
    }
}

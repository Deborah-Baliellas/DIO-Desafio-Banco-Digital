package banco_digital.contas;

import banco_digital.Cliente;

public class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0d;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    // Impede que não haja contas de mesmo número
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (numero != other.numero)
            return false;
        return true;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    // INÍCIO DOS MÉTODOS DE OPERAÇÕES BANCÁRIAS

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void escolherModalidadeConta() {
        String modalidade;
        System.out.println("Em qual modalidade deseja depositar?");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        
    }

    public void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome() + ", CPF: " + this.cliente.getCpf());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Conta número: " + this.numero);
        System.out.println("Saldo: R$ " + this.saldo);
    }

}

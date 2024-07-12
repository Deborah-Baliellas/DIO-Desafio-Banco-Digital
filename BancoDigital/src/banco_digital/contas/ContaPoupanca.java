package banco_digital.contas;

import banco_digital.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("============ EXTRATO CONTA POUPANÇA ============");
        super.imprimirInfosComuns();
    }

}

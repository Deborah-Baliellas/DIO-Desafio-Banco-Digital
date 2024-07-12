package banco_digital.contas;

import java.util.Set;

import banco_digital.Cliente;

public class ContaCorrente extends Conta {
    
    
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("============ EXTRATO CONTA CORRENTE ============");
        super.imprimirInfosComuns();
    }

}

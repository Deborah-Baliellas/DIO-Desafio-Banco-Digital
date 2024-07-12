package banco_digital;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

import banco_digital.contas.Conta;
import banco_digital.contas.ContaCorrente;
import banco_digital.contas.ContaPoupanca;

public class Main {

    public static void main(String[] args) throws Exception {
        Cliente novoCliente = new Cliente(null, null);
        ContaCorrente contaCorrente = new ContaCorrente(novoCliente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(novoCliente);
        Conta conta = new Conta(null);
        BancoDigital bancoDigital = new BancoDigital();
        Scanner scan = new Scanner(System.in);

        boolean continuar = true;
        String sair;
        String novoNome;
        String novoCpf;
        String opcaoMenu;
        double valorSaque;
        double valorDeposito;
        double valorTransfir;
String modalidade;

        System.out.println("Bem vindo(a) ao Banco " + bancoDigital.getNome()
                + "!\nEsperamos que tenha uma experiência inesquecível conosco!\n");

        while (continuar) {
            System.out.println("Informe o número da opção desejada:\n");

            System.out.println("1 - Criar uma nova Conta Corrente.");
            System.out.println("2 - Criar uma nova Conta Poupança.");
            System.out.println("3 - Atualizar nome de uma Conta existente.");
            System.out.println("4 - Fazer um depósito.");
            System.out.println("5 - Fazer um saque.");
            System.out.println("6 - Fazer uma transferência.");
            System.out.println("7 - Extrato da Conta Corrente.");
            System.out.println("8 - Extrato da Conta Poupança.");
            System.out.println("9 - Sair.");

            opcaoMenu = scan.next();
            scan.nextLine();

            switch (opcaoMenu) {
                case "1": {
                    System.out.println("Informe o nome do titular da nova conta:");
                    novoNome = scan.nextLine();
                    novoCliente.setNome(novoNome);

                    System.out.println("Informe o CPF do titular:");
                    novoCpf = scan.nextLine();
                    novoCliente.setCpf(novoCpf);

                    contaCorrente.imprimirExtrato();

                    // criar uma lista de clientes (por nome ou por conta?)
                    // Separar os clientes de cc e cp
                    
                    System.out.println("Conta Corrente criada com sucesso!");
                }
                    break;

                case "2": {
                    System.out.println("Informe o nome do titular da nova conta:");
                    novoNome = scan.nextLine();
                    novoCliente.setNome(novoNome);

                    System.out.println("Informe o CPF do titular:");
                    novoCpf = scan.nextLine();
                    novoCliente.setCpf(novoCpf);

                    contaPoupanca.imprimirExtrato();

                    System.out.println("Conta Poupança criada com sucesso!\n");

                }
                    break;

                case "3": {
                    String cpfAlterarConta = null;
                    String nomeAlterarConta = null;
                    conta.escolherModalidadeConta();
                    modalidade = scan.nextLine();

                    if (modalidade.equals("1")) {
                        System.out.println(
                                "Informe o número do CPF do titular da conta Corrente que deseja realizar a atualização: ");
                        cpfAlterarConta = scan.nextLine();
                        if (cpfAlterarConta.equals(novoCliente.getCpf())) {
                            System.out.println("Informe o novo nome:");
                            nomeAlterarConta = scan.nextLine();
                            novoCliente.setNome(nomeAlterarConta);

                            System.out.println("Atualização de nome realizada com sucesso!");

                            contaCorrente.imprimirExtrato();
                        } else {
                            System.out.println("CPF não encontrado.");
                        }
                    } else if (modalidade.equals("2")) {
                        System.out.println(
                                "Informe o número do CPF do titular da conta Poupança que deseja realizar a atualização: ");
                        cpfAlterarConta = scan.nextLine();
                        if (cpfAlterarConta.equals(novoCliente.getCpf())) {
                            System.out.println("Informe o novo nome:");
                            nomeAlterarConta = scan.nextLine();
                            novoCliente.setNome(nomeAlterarConta);

                            System.out.println("Atualização de nome realizada com sucesso!");

                            contaPoupanca.imprimirExtrato();

                        } else {
                            System.out.println("CPF não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    // checar se conta existe mesmo.
                }
                    break;

                case "4": { // depósito
                    conta.escolherModalidadeConta();
                    modalidade = scan.nextLine();

                    if (modalidade.equals("1")) {
                        System.out.println("Informe o valor que deseja depositar: ");
                        valorDeposito = scan.nextDouble();
                        contaCorrente.depositar(valorDeposito);
                        System.out.println("Depósito efetuado com sucesso!");
                        contaCorrente.imprimirExtrato();

                    } else if (modalidade.equals("2")) {
                        System.out.println("Informe o valor que deseja depositar: ");
                        valorDeposito = scan.nextDouble();
                        contaPoupanca.depositar(valorDeposito);
                        System.out.println("Depósito efetuado com sucesso!");
                        contaPoupanca.imprimirExtrato();
                    } else {
                        System.out.println("Opção inválida.");

                        // Colocar loop para dar outra oportunidade de escolher.
                    }
                }

                    break;

                case "5": { // saque
                    conta.escolherModalidadeConta();
                    modalidade = scan.nextLine();

                    if (modalidade.equals("1")) {
                        System.out.println("Informe o valor que deseja sacar: ");
                        valorSaque = scan.nextDouble();
                        if (contaCorrente.getSaldo() < valorSaque) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            contaCorrente.sacar(valorSaque);
                            System.out.println("Saque efetuado com sucesso!");
                            contaCorrente.imprimirExtrato();
                        }

                    } else if (modalidade.equals("2")) {
                        System.out.println("Informe o valor que deseja sacar: ");
                        valorSaque = scan.nextDouble();

                        if (contaPoupanca.getSaldo() < valorSaque) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            contaPoupanca.sacar(valorSaque);
                            System.out.println("Saque efetuado com sucesso!");
                            contaPoupanca.imprimirExtrato();
                        }

                    } else {
                        System.out.println("Opção inválida.");
                    }

                }
                    break;

                case "6": { // transferência
                    conta.escolherModalidadeConta();
                    modalidade = scan.nextLine();

                    if (modalidade.equals("1")) {
                        System.out.println("Qual o valor que deseja transferir?");
                        valorTransfir = scan.nextDouble();

                        if (contaCorrente.getSaldo() < valorTransfir) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            contaCorrente.transferir(valorTransfir, contaPoupanca);

                            System.out.println("Transferência realizada com sucesso!");
                            contaCorrente.imprimirExtrato();
                            contaPoupanca.imprimirExtrato();
                        }

                    } else if (modalidade.equals("2")) {
                        System.out.println("Qual o valor que deseja transferir?");
                        valorTransfir = scan.nextDouble();

                        if (contaPoupanca.getSaldo() < valorTransfir) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            contaPoupanca.transferir(valorTransfir, contaCorrente);

                            System.out.println("Transferência realizada com sucesso!");
                            contaPoupanca.imprimirExtrato();
                            contaCorrente.imprimirExtrato();
                        }

                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                    break;

                case "7": {
                    contaCorrente.imprimirExtrato();
                }
                    break;

                case "8": {
                    contaPoupanca.imprimirExtrato();

                }
                    break;

                case "9": {

                    continuar = false;

                }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");

                    break;
            }

        }
        System.out.println("Obrigado por usar o TepsBank! Até a próxima!");
        scan.close();
    }

}

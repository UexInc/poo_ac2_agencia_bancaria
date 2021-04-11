package poo_ac2_agencia_bancaria;

import java.util.Scanner;

/*
* Gabriel de Melo Marcondes - 1903416
* Geisa Pereira Souza - 1903417
* Raphael Vinicius Oliveira da Silva - 1902604
* Ricardo de Oliveira Trovado - 1903223
* Willian Donha dos Santos Pestana - 1902650
*/

public class Banco {

	public static Scanner entrada;
	
	/*
     * Mostrar detalhes de todas as contas instanciadas
     * */
    public static void mostrarInfo(ContaBancaria[] contas) {
        System.out.println("\nContas de todos os clientes:");
        for (int i = 0; i < contas.length; i++) {
            System.out.println("[" + i + "]" + contas[i].toString());
        }
        System.out.println("");
    }
 
	/*
     * Interage com o usuário para sacar com base no indice da conta informado por ele.
     * */
    public static void interacaoSacar(ContaBancaria[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O saque será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
 
        System.out.print("Qual o valor do saque? ");
        double saque = entrada.nextDouble();
        contas[indiceConta].sacar(saque);
        System.out.println("Saque finalizado.\n");
    }
    
   	/*
    * Interage com o usuário para depositar com base no indice da conta informado por ele.
    * */
    public static void interacaoDepositar(ContaBancaria[] contas) {
    	boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O depósito será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
 
        System.out.print("Qual o valor do depósito? ");
        double deposito = entrada.nextDouble();
        contas[indiceConta].depositar(deposito);
        System.out.println("depósito finalizado.\n");
    }
    
    /*
     * Interage com o usuário para fazer a transferência de valores entre duas contas.
     * Verificando se o usuário informa índices que são válidos para não dar erro.
     * */
    public static void interacaoTransferir(ContaBancaria[] contas) {
    	// Pega o índice da conta que fará a transfaerência.
    	boolean clienteValido_enviar = false;
        int indiceConta_enviar = -1;
        mostrarInfo(contas);
        while (!clienteValido_enviar) {
            System.out.print("Qual cliente irá transferir? (0 a " + (contas.length - 1) + "): ");
            indiceConta_enviar = entrada.nextInt();
            if (indiceConta_enviar >= 0 && indiceConta_enviar < contas.length) {
                clienteValido_enviar = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        
        System.out.println("-------------------------------");

    	// Pega o índice da conta que receberá a transfaerência.
    	boolean clienteValido_receber = false;
        int indiceConta_receber = -1;
        while (!clienteValido_receber) {
            System.out.print("Qual cliente irá receber? (0 a " + (contas.length - 1) + "): ");
            indiceConta_receber = entrada.nextInt();
            if (indiceConta_receber >= 0 && indiceConta_receber < contas.length && indiceConta_receber != indiceConta_enviar) {
                clienteValido_receber = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
 
        // Pede o valor da transferência.
        System.out.print("Qual o valor da transferência? ");
        double transferencia = entrada.nextDouble();
        // Faz a transferência.
        contas[indiceConta_enviar].transferir(transferencia, contas[indiceConta_receber]);
        System.out.println("Transferência finalizada.\n");        
    }
	
	// Mostrar CPMF de cada conta bancaria
	public static void mostrarCpmf(ContaBancaria[] contas) {
		System.out.println("");
		for(ContaBancaria c : contas) {
			System.out.println(c.toString() + " = CPMF: " + c.getCpmf());
		}
		System.out.println("");
	}
 
    public static void main(String[] args) {
		// Criação das multiplas contas
        ContaBancaria[] contas = new ContaBancaria[5];
		// Atribuição das multiplas contas
        contas[0] = new ContaBancaria("Marcos", 1000.00);
        contas[1] = new ContaBancaria("Júlia", 250.00);
        contas[2] = new ContaBancaria("João", 2500.00);
        contas[3] = new ContaBancaria("Roberto", 3000.00);
        contas[4] = new ContaBancaria("Janaína", 4500.00);
 		
		// Entrada do usuário
        entrada = new Scanner(System.in);
        boolean sair = false;
  		
		// Menu das opções
        while (!sair) {
			// Número de cada opção do menu
            System.out.println("Escolha uma operação:");
			System.out.println("(0) verificar cpmf");
            System.out.println("(1) mostrar informações de todas as contas");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) transferir");
            System.out.println("(5) sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt(); // Entrada do usuário para escolher opção
            System.out.println();
 
            switch (escolha) {
			case 0:
				mostrarCpmf(contas);
				break;
            case 1:
                mostrarInfo(contas);
                break;
            case 2:
                interacaoSacar(contas);
                break;
            case 3:
                interacaoDepositar(contas);
                break;
            case 4:
                interacaoTransferir(contas);
                break;
            case 5:
                sair = true;
                break;
            default:
                System.out.println("Opção inválida!");
            }
            System.out.println();
        }
        System.out.println("Fim do programa!");
    }


}

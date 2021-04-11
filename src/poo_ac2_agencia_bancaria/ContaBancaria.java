package poo_ac2_agencia_bancaria;

import java.util.Random;

/*
* Gabriel de Melo Marcondes - 1903416
* Geisa Pereira Souza - 1903417
* Raphael Vinicius Oliveira da Silva - 1902604
* Ricardo de Oliveira Trovado - 1903223
* Willian Donha dos Santos Pestana - 1902650
*/

public class ContaBancaria {
	private static int ultimoNumeroConta = 1000; // Último número de conta utilizado
    private String correntista; // correntista
    private int numeroConta; // número da conta
    private double saldo; // saldo da conta
	private double cpmf; //cpmf
	private String senha; // senha
 
	// Conta bancária e atributos
    public ContaBancaria(String correntista, double saldo) {
        ultimoNumeroConta++;
        this.numeroConta = ultimoNumeroConta;
        this.saldo = saldo;
        this.correntista = correntista;
		this.senha = this.criarSenha();
    }

	// depositar valores 
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }

	// sacar valores
    public void sacar(double valor) {
        this.saldo = this.saldo - valor;
		this.cpmf += ( valor * (0.25 / 100) );
    }

	// transferir valores
    public void transferir(double valor, ContaBancaria contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
 
	// retornar saldo
    public double getSaldo() {
        return this.saldo;
    }
 
	// retornar o numero da conta
    public int getNumeroConta() {
        return this.numeroConta;
    }
 
	// retornar correntista e seu saldo
    public String toString() {
        return "Conta de " + this.correntista + " - Saldo de R$ " + this.saldo;
    }

	// criar senha aleatória
	private String criarSenha() {
		Random random = new Random();
		String senha = "";
		while (senha.length() < 6) {
			senha += random.nextInt(9);
		}
		return senha;
	}

	// retornar cpmf
	public double getCpmf() {
		return this.cpmf;
	}
	
	// retornar senha
	public String getSenha() {
		return this.senha;
	}

}

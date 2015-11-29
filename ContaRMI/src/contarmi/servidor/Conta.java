package contarmi.servidor;

public class Conta {
	
	private int conta;
	private double saldo;
	private double limite;
	private String nome;
	
	
	public Conta(String nome, int conta) {
		this.nome = nome;
		this.conta = conta;
		saldo = 0;
	}
	
	public void saldo(){
		System.out.println("Saldo");
		System.out.println("Nome:" + this.nome);
		System.out.println("Número da conta: " + this.conta);
		System.out.printf("Saldo atual: %.2f\n", this.saldo);
	}
	
	public boolean sacar(double valor){
		
		if (saldo >= valor){
			saldo = saldo - valor;
			return true;
		}
		
		return false;
		
	}
	
	public void depositar(double valor){
		
		saldo = saldo + valor;
		
	}
	
	public boolean transferir(double valor, Conta conta2){
		
		if (valor > 0){
			this.sacar(valor);
			conta2.depositar(valor);
			return true;
		}
		
		return false;
		
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		
		return saldo;
		
	}
	
	public String getSaldoString() {

		return "Saldo\n" + "Nome: " + this.nome +"\n"+ "Número da conta: " + this.conta + "\n" + "Saldo atual: " + this.saldo;
		
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
